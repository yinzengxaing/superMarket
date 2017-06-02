package com.superMarket.employee.dao;

import java.util.List;

import com.superMarket.employee.bean.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployeeList();
	
	public Employee getEmployeeById(String id);
	
	public int addEmployee(Employee employee);
	
	public int deleteEmployee(String id );
	
	public int updateEmployee(Employee employee);
	
	public List<Employee> selectByName(String name);
	
	public List<Employee> selectByDuty(String duty);
	
	public List<Employee> selectByDepartment(String department);
	
}
