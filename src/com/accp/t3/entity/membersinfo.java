package com.accp.t3.entity;

public class membersinfo {
	private  Integer   id;
	private  String   mname;
	private  String   mgender;
	private  Integer   mage;
	private  String   maddress;
	private  String   memail;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public Integer getMage() {
		return mage;
	}
	public void setMage(Integer mage) {
		this.mage = mage;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public membersinfo(Integer id, String mname, String mgender, Integer mage, String maddress, String memail) {
		super();
		this.id = id;
		this.mname = mname;
		this.mgender = mgender;
		this.mage = mage;
		this.maddress = maddress;
		this.memail = memail;
	}
	public membersinfo() {
		super();
	}
	
	@Override
	public String toString() {
		return "membersinfo [id=" + id + ", mname=" + mname + ", mgender=" + mgender + ", mage=" + mage + ", maddress="
				+ maddress + ", memail=" + memail + "]";
	}
	
	

}
