package com.qx.ar.modle;

public class Company {
	private Integer id;
	private String companyName;
	private String address;
	private String contact;
	private String registerNum;
	private String apptoken;
	private Integer size;
	private Integer start;
	public Company(){
		super();
	}
	public Company(String companyName, String address, String contact, String registerNum, String apptoken
			) {
		super();
		this.companyName = companyName;
		this.address = address;
		this.contact = contact;
		this.registerNum = registerNum;
		this.apptoken=apptoken;
	}
	public Company(String apptoken){
		super();
		this.apptoken=apptoken;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRegisterNum() {
		return registerNum;
	}
	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}
	public String getApptoken() {
		return apptoken;
	}
	public void setApptoken(String apptoken) {
		this.apptoken = apptoken;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", address=" + address + ", contact=" + contact
				+ ", registerNum=" + registerNum + ", apptoken=" + apptoken + ", size=" + size + ", start=" + start
				+ "]";
	}
	



}
