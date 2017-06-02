package com.superMarket.employee.bean;

public class Employee {
	
	private String id;
	private String name;
	private int age;
	private String sex;
	private String duty;
	private String department;
	private String phone;
	private String officePhone;
	private String fax;
	private String email;
	private String address;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", duty=" + duty
				+ ", department=" + department + ", phone=" + phone + ", officePhone=" + officePhone + ", fax=" + fax
				+ ", email=" + email + ", address=" + address + "]";
	}
	public Employee(String id, String name, int age, String sex, String duty, String department, String phone,
			String officePhone, String fax, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.duty = duty;
		this.department = department;
		this.phone = phone;
		this.officePhone = officePhone;
		this.fax = fax;
		this.email = email;
		this.address = address;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
