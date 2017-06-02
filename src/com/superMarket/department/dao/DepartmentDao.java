package com.superMarket.department.dao;

import java.util.List;

import com.superMarket.department.bean.Department;

public interface DepartmentDao {
	public List<Department> getDepartmentList();
	
	public Department getDepartmentById(String id);
	
	public int addDepartment(Department department);
	
	public int deleteDepartment(String id);
	
	public int updateDepartment(Department department);
	
	public List<Department> selectByDepname(String depName);
	
	public List<Department> selectByPrincipal(String principal);
}
