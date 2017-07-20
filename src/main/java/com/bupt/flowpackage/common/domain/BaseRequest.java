package com.bupt.flowpackage.common.domain;

import com.bupt.flowpackage.utils.RandomUtil;

public class BaseRequest extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String requestNo = RandomUtil.produceRequestNo();
	
	private String operatorId = "web";
	/** 一页显示的记录数 */
	private int pageSize = Page.DEFAULT_PAGE_SIZE;
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

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
}
