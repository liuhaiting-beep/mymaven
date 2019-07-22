package com.accp.t2.entity;

import java.util.Set;

/**
 * 招标信息类
 * @author Lenovo
 *
 */
public class Tender {
	private Integer tender_id;//编号
	private String project_name;  //工程名
	
	private Set<Bid> bid;//投标信息字段id
	
	
	
	public Set<Bid> getBid() {
		return bid;
	}
	public void setBid(Set<Bid> bid) {
		this.bid = bid;
	}
	public Integer getTender_id() {
		return tender_id;
	}
	public void setTender_id(Integer tender_id) {
		this.tender_id = tender_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
	public Tender() {
		super();
	}
	
	public Tender(Integer tender_id, String project_name) {
		super();
		this.tender_id = tender_id;
		this.project_name = project_name;
	}
	
	public Tender(Integer tender_id, String project_name, Set<Bid> bid) {
		super();
		this.tender_id = tender_id;
		this.project_name = project_name;
		this.bid = bid;
	}
	@Override
	public String toString() {
		return "Tender [tender_id=" + tender_id + ", project_name=" + project_name + ", bid=" + bid + "]";
	}


	
	
	

}
