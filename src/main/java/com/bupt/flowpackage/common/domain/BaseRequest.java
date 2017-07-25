package com.bupt.flowpackage.common.domain;

import org.apache.commons.lang.StringUtils;

import com.bupt.flowpackage.utils.RandomUtil;

public class BaseRequest extends BaseBean {

	private static final long serialVersionUID = 1L;
	
	private static ThreadLocal<String> requestNoLocal = new ThreadLocal<String>();
	
	private String operatorId = "web";
	/** 一页显示的记录数 */
	private int pageSize = Page.DEFAULT_PAGE_SIZE;
	/** 当前页码 */
	private int pageNum = 1;
	
	public BaseRequest() {
		String requestNo = requestNoLocal.get();
		if(StringUtils.isBlank(requestNo)) {
			this.setRequestNo(RandomUtil.produceRequestNo());
			
		}
	}
	
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
		return requestNoLocal.get();
	}

	public void setRequestNo(String requestNo) {
		requestNoLocal.set(requestNo);
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
}
