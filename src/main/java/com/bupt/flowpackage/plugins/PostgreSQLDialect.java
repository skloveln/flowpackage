package com.bupt.flowpackage.plugins;

public class PostgreSQLDialect extends PageDialect {

    @Override
    public String getPaginationSQL(String sql, int offset, int limit) {
        StringBuffer buffer = new StringBuffer( sql.length()+20 ).append(sql);
        if(offset > 0){
            buffer.append(" limit "+limit+" offset "+offset+" ");
        }else{
            buffer.append(" limit "+limit+" ");
        }
		return buffer.toString();
    }
}
