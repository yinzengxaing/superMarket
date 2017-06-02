package com.superMarket.employee.dao;

import java.util.List;

import com.superMarket.employee.bean.Employee;
import com.superMarket.utils.BaseDao;

public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {

	@Override
	public List<Employee> getEmployeeList() {
		String sql = "select * from employee";
		return this.getBeanList(sql);
	}

	@Override
	public Employee getEmployeeById(String id) {
		String sql = "select * from employee where id =?";
		return this.getBean(sql, id);
	}

	@Override
	public int addEmployee(Employee employee) {
		String sql = "insert into employee (name, age, sex, duty, department, phone, officePhone, fax, email, address)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		return this.update(sql, employee.getName(), employee.getAge(), employee.getSex(), employee.getDuty(),
				employee.getDepartment(), employee.getPhone(), employee.getOfficePhone(), employee.getFax(),
				employee.getEmail(), employee.getAddress());
	}

	@Override
	public int deleteEmployee(String id) {
		String sql = "delete from employee where id = ?";
		return this.update(sql, id);
	}

	@Override
	public int updateEmployee(Employee employee) {
		String sql = "update employee set name=?, age=?, sex=?, duty=?, department=?, phone=?, officePhone=?, fax=?, email=?, address=? "
				+ "where id=?";
		return this.update(sql, employee.getName(), employee.getAge(), employee.getSex(), employee.getDuty(),
				employee.getDepartment(), employee.getPhone(), employee.getOfficePhone(), employee.getFax(),
				employee.getEmail(), employee.getAddress(),employee.getId());
	}

	@Override
	public List<Employee> selectByName(String name) {
		
		name = "%"+name+"%";
		
		String sql = "select * from employee where name like ?";
		return this.getBeanList(sql, name);
	}

	@Override
	public List<Employee> selectByDuty(String duty) {
		duty = "%"+duty+"%";
		String sql = "select * from employee where duty like ?";
		return this.getBeanList(sql, duty);
	}

	@Override
	public List<Employee> selectByDepartment(String department) {
		department = "%"+department+"%";
		String sql = "select * from employee where department like ?";
		return this.getBeanList(sql, department);
	}

}
