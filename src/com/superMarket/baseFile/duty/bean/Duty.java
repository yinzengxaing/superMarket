package com.superMarket.baseFile.duty.bean;
/**
 * 职务实体类
 * @author administrator
 *
 */
public class Duty {

	private  String id;
	private String dutyName;
	private String description;//职务描述
	public Duty() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Duty(String id, String dutyName, String description) {
		super();
		this.id = id;
		this.dutyName = dutyName;
		this.description = description;
	}





	@Override
	public String toString() {
		return "Duty [id=" + id + ", dutyName=" + dutyName + ", description=" + description + "]";
	}




	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDutyName() {
		return dutyName;
	}
	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
	
}
