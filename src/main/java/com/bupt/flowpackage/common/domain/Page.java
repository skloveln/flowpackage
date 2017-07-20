package com.bupt.flowpackage.common.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Page<T> extends BaseBean{
	private static final long serialVersionUID = 1L;
	
	public static final int DEFAULT_PAGE_SIZE = 10; 
	/** 一页显示的记录数 */
	private int pageSize = DEFAULT_PAGE_SIZE;
	/** 记录总数 */
	private long total = -1;
	/** 当前页码 */
	private int pageNum = 1;
	/** 结果集存放List */
	private List<T> rows;

	public Page() {}
	public Page(int pageNum, int pageSize, long total, List<T> rows) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.total = total;
		this.rows = rows;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	// 计算总页数
	public long getTotalPages() {
		long totalPages;
		if (total % pageSize == 0) {
			totalPages = total / pageSize;
		} else {
			totalPages = (total / pageSize) + 1;
		}
		return totalPages;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@JsonIgnore
	public int getOffset() {
		return (pageNum - 1) * pageSize;
	}

	@JsonIgnore
	public long getEndIndex() {
		if (getOffset() + pageSize > total) {
			return total;
		} else {
			return getOffset() + pageSize;
		}
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
