package com.superMarket.department.dao;

import java.util.List;

import com.superMarket.department.bean.Department;
import com.superMarket.utils.BaseDao;

public class DepartmentDaoImpl extends BaseDao<Department> implements DepartmentDao {

	@Override
	public List<Department> getDepartmentList() {
		
		String sql = "select * from department";
		
		return this.getBeanList(sql);
	}

	@Override
	public Department getDepartmentById(String id) {
		String sql = "select * from department where id = ?" ;
		
		return this.getBean(sql, id);
	}

	@Override
	public int addDepartment(Department department) {
		String sql = "INSERT INTO department (depName, principal, description) VALUES (?,?,?)";
		return this.update(sql, department.getDepName(), department.getPrincipal(), department.getDescription());
	}

	@Override
	public int deleteDepartment(String id) {
		String sql = "delete from department where id = ?";
		return this.update(sql, id);
	}

	@Override
	public int updateDepartment(Department department) {
		String sql = "update department set depName=?, principal=?, description=? where id = ? ";
		return this.update(sql,department.getDepName(), department.getPrincipal(), department.getDescription(),department.getId() );
	}

	@Override
	public List<Department> selectByDepname(String depName) {
		depName = "%"+depName+"%";
		String sql ="select * from department where depName like ?  ";
		return this.getBeanList(sql, depName);
	}

	@Override
	public List<Department> selectByPrincipal(String principal) {
		principal = "%"+principal+"%";
		String sql ="select * from department where principal like ?  ";
		return this.getBeanList(sql, principal);
		
	}

}
