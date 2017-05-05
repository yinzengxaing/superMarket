package com.superMarket.baseFile.warehouse.bean;
/**
 * 仓库负责人
 * @author administrator
 *
 */
public class Warehouse {

	private String  id ; //仓库编号
	private String name; //仓库名
	private String principal; //主要负责人
	private String bewrite; //描述
	public Warehouse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Warehouse(String id, String name, String principal, String bewrite) {
		super();
		this.id = id;
		this.name = name;
		this.principal = principal;
		this.bewrite = bewrite;
	}
	@Override
	public String toString() {
		return "Warehouse [id=" + id + ", name=" + name + ", principal=" + principal + ", bewrite=" + bewrite + "]";
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
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getBewrite() {
		return bewrite;
	}
	public void setBewrite(String bewrite) {
		this.bewrite = bewrite;
	}
	
	
}
