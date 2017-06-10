package com.bupt.flowpackage.plugins;

public class MySQLDialect extends PageDialect {

    @Override
    public String getPaginationSQL(String sql, int offset, int limit) {
        StringBuffer pagingSelect = new StringBuffer(sql.toUpperCase().trim());
        pagingSelect
                .append(" LIMIT "+offset+","+limit);
        return pagingSelect.toString().replaceAll("\n", "");
    }
}
