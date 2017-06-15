package com.bupt.flowpackage.common.domain;

public class BaseRequestPage extends BaseRequest{

	private static final long serialVersionUID = 1L;

	/** 一页显示的记录数 */
	private int pageSize = 20;
	/** 当前页码 */
	private int pageNum = 1;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
