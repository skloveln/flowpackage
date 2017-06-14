package com.bupt.flowpackage.common.domain;

import com.bupt.flowpackage.utils.RandomUtil;

public class BaseRequest extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String requestNo = RandomUtil.produceRequestNo();
	
	private String operatorId = "api";

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
