package com.bupt.flowpackage.utils;

import com.bupt.flowpackage.common.domain.Page;
import com.github.pagehelper.PageInfo;

public class PageRespUtil {

	public static <T> Page<T> createPage(PageInfo<T> pageInfo) {
		Page<T> page = new Page<T>();
		page.setRows(pageInfo.getList());
		page.setTotal(pageInfo.getTotal());
		page.setPageNum(pageInfo.getPageNum());
		page.setPageSize(pageInfo.getPageSize());
		return page;
	}
	
}
