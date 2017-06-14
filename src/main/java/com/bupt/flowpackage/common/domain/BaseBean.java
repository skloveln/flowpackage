package com.bupt.flowpackage.common.domain;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString(){
		return JSONObject.toJSONString(this);
	}
}
