package com.accp.t3.entity;

import java.util.List;

public class Page<T> {
	private int currn;
	private int pagesize;
	private int totalsize;
	private List<membersinfo> list;
	private int totalpage;
	private int prev;
	private int next;
	
	
	public int getCurrn() {
		return currn;
	}
	public void setCurrn(int currn) {
		this.currn = currn;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalsize() {
		return totalsize;
	}
	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}
	public List<membersinfo> getList() {
		return list;
	}
	public void setList(List<membersinfo> list) {
		this.list = list;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public Page(int currn, int pagesize, int totalsize, List<membersinfo> list) {
		super();
		this.currn = currn;
		this.pagesize = pagesize;
		this.totalsize = totalsize;
		this.list = list;
		this.totalpage = totalsize % pagesize==0 ? totalsize/pagesize:totalsize/pagesize+1;
		this.prev = currn <= 1 ?1:currn-1;
		this.next = currn >= totalpage ? totalpage:currn+1;
	}
	
	
	
	
}
