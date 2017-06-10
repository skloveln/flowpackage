package com.bupt.flowpackage.plugins;

public abstract class PageDialect {

    public static enum Type{
        POSTGRESQL,
        MYSQL
    }

    public abstract String getPaginationSQL(String sql, int offset, int limit);


    public  String getTotalSql(String sql){
        String upperSql = sql.toUpperCase();
        StringBuffer builder = new StringBuffer();
        builder.append("SELECT COUNT(1) FROM ( ");
        builder.append(upperSql);
        builder.append(" ) tmp_count ");
        return builder.toString();
    }



}
