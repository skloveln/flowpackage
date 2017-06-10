package com.bupt.flowpackage.plugins;

import java.util.List;

public class Pagination {
	
	private List<?> rows;
	
	private int limit;
	
	private int offset;
	
	private long total;

	public Pagination(){
		
	}
	
	public Pagination(int limit, int offset){
		this.limit = limit;
		this.offset = offset;
	}


	public List<?> getRows() {
		return rows;
	}


	public void setRows(List<?> rows) {
		this.rows = rows;
	}


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}


	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


	public long getTotal() {
		return total;
	}


	public void setTotal(long total) {
		this.total = total;
	}
	
	
}
