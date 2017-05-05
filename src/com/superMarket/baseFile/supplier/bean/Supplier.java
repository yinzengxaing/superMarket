package com.superMarket.baseFile.supplier.bean;
/**
 * 供货商实体类
 * @author administrator
 *
 */
public class Supplier {

	private String id;
	private String name;
	private String address;
	private String provide;
	private String linkman;
	private String linkPhone;
	private String faxes;
	private String postNum;
	private String bankNum;
	private String netAddress;
	private String emailAddress;
	private String remark;
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(String id, String name, String address, String provide, String linkman, String linkPhone,
			String faxes, String postNum, String bankNum, String netAddress, String emailAddress, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.provide = provide;
		this.linkman = linkman;
		this.linkPhone = linkPhone;
		this.faxes = faxes;
		this.postNum = postNum;
		this.bankNum = bankNum;
		this.netAddress = netAddress;
		this.emailAddress = emailAddress;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", address=" + address + ", provide=" + provide + ", linkman="
				+ linkman + ", linkPhone=" + linkPhone + ", faxes=" + faxes + ", postNum=" + postNum + ", bankNum="
				+ bankNum + ", netAddress=" + netAddress + ", emailAddress=" + emailAddress + ", remark=" + remark
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProvide() {
		return provide;
	}
	public void setProvide(String provide) {
		this.provide = provide;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getFaxes() {
		return faxes;
	}
	public void setFaxes(String faxes) {
		this.faxes = faxes;
	}
	public String getPostNum() {
		return postNum;
	}
	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}
	public String getBankNum() {
		return bankNum;
	}
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
	public String getNetAddress() {
		return netAddress;
	}
	public void setNetAddress(String netAddress) {
		this.netAddress = netAddress;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
