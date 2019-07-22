package com.accp.t2.entity;

/**
 * 投标信息类
 * @author Lenovo
 *
 */
public class Bid {
	private Integer bid_id;//编号
	private String company;  //投标公司名
	public Integer getBid_id() {
		return bid_id;
	}
	public void setBid_id(Integer bid_id) {
		this.bid_id = bid_id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	public Bid() {
		super();
	}
	public Bid(Integer bid_id, String company) {
		super();
		this.bid_id = bid_id;
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "Bid [bid_id=" + bid_id + ", company=" + company + "]";
	}
	     
	
}
