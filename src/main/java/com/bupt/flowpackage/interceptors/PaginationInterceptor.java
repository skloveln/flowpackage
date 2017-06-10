package com.bupt.flowpackage.interceptors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bupt.flowpackage.plugins.MySQLDialect;
import com.bupt.flowpackage.plugins.PageDialect;
import com.bupt.flowpackage.plugins.Pagination;
import com.bupt.flowpackage.plugins.PostgreSQLDialect;
import com.bupt.flowpackage.utils.ReflectHelper;


@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PaginationInterceptor implements Interceptor {

	private static final Logger log = LoggerFactory.getLogger(PaginationInterceptor.class);
	
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler  statementHandler = (RoutingStatementHandler)invocation.getTarget();
		BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler, "delegate");
		MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");
        MetaObject metaStatementHandler = MetaObject.forObject(
                statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
		
        Configuration configuration = (Configuration) metaStatementHandler
                .getValue("delegate.configuration");

        String pageSqlId = configuration.getVariables().getProperty("pageSqlId");
        if(StringUtils.isBlank(pageSqlId)){
        	log.debug("Property pageSqlId is not setted,use default '.*Page$' ");
        	pageSqlId = ".*Page$";
        }

        PageDialect.Type databaseType = null;
        try {
            databaseType = PageDialect.Type.valueOf(configuration
                    .getVariables().getProperty("dialect").toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == databaseType) {
            throw new RuntimeException(
                    "the value of the dialect property in configuration.xml is not defined : "
                            + configuration.getVariables().getProperty(
                            "dialect"));
        }
        PageDialect dialect = null;
        switch (databaseType) {
            case POSTGRESQL:
                dialect = new PostgreSQLDialect();
                break;
            case MYSQL:
                dialect = new MySQLDialect();
                break;
            default:
                dialect = new PostgreSQLDialect();
        }

        if(mappedStatement.getId().matches(pageSqlId)){
        	 BoundSql boundSql = (BoundSql) delegate.getBoundSql(); 
        	 Object parameterObject = boundSql.getParameterObject();  
        	 if(null == parameterObject){
        		 log.info("parameterObject is null!");
        		 return invocation.proceed(); 
        	 }else{
        		 Pagination pageView = null;
        		 if(parameterObject instanceof Pagination){
        			 pageView = (Pagination) parameterObject;
        		 }else if(parameterObject instanceof Map){
        			 for (Entry entry : (Set<Entry>) ((Map) parameterObject).entrySet()) {
							if (entry.getValue() instanceof Pagination) {
								pageView = (Pagination) entry.getValue();
								break;
							}
						}
        		 }else{
        			 pageView = ReflectHelper.getValueByFieldType(parameterObject, Pagination.class);
						if (pageView == null) {
							return invocation.proceed();
						}
        		 }
        		 
    			PreparedStatement countStmt = null;
    			ResultSet rs = null;
    			String sql = boundSql.getSql();
    			try {
    				Connection connection = (Connection) invocation.getArgs()[0];
    				String countSql = "select count(1) from (" + sql
    						+ ") tmp_count"; // 记录统计
    				countStmt = connection.prepareStatement(countSql);
    				ReflectHelper.setValueByFieldName(sql, "sql",countSql);
    				DefaultParameterHandler parameterHandler = new DefaultParameterHandler(
    						mappedStatement, parameterObject, boundSql);
    				parameterHandler.setParameters(countStmt);
    				rs = countStmt.executeQuery();
    				int count = 0;
    				if (rs.next()) {
    					count = ((Number) rs.getObject(1)).intValue();
    				}
    				pageView.setTotal(count);
    			} finally {
    				try {
    					rs.close();
    				} catch (Exception e) {
    				}
    				try {
    					countStmt.close();
    				} catch (Exception e) {
    				}
    			}
    			
            	String pageSql = dialect.getPaginationSQL(sql, pageView.getOffset(), pageView.getLimit()); 
            	ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql);        		 
        	 }
        	 
        }
		return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
    
	public int getTotalCount(Invocation invocation, String sql,
			PageDialect dialect) throws SQLException {
		Connection connection = (Connection) invocation.getArgs()[0];
		String countSql = dialect.getTotalSql(sql); // 记录统计
		PreparedStatement countStmt = connection.prepareStatement(countSql);
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		//修改未设置参数BUG
		statementHandler.getParameterHandler().setParameters(countStmt);

		ResultSet rs = countStmt.executeQuery();
		int count = 0;
		if (rs.next()) {
			count = rs.getInt(1);
		}
		
		rs.close();
		countStmt.close();
		rs = null;
		countStmt = null;
		return count;
	}
}
