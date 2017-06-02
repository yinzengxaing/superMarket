package com.superMarket.department.bean;
/**
 * 部门相关实体类
 * @author yinzengxaing
 *
 */
public class Department {
	private String id ;
	private String depName;
	private String principal;
	private String description;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String id, String depName, String principal, String description) {
		super();
		this.id = id;
		this.depName = depName;
		this.principal = principal;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", depName=" + depName + ", principal=" + principal + ", description="
				+ description + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
