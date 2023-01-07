package com.qut.entity;

import java.util.List;


public class PageBean<T> {
	private List<T> pageData;		
	private int totalCount = 0 ;	
	private int currentPage = 1;	
	private int pageSize = 5;				
	private int totalPage = 1;		
	private int startNum = 1;		
	private int endNum = 1; 		
	
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		totalPage = totalCount / pageSize;
		if (totalCount == 0 || totalCount%pageSize != 0)  totalPage++;
		return totalPage;
	}	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartNum() {
		return (this.currentPage-1)*this.pageSize;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return this.currentPage*this.pageSize +1;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}	
}

