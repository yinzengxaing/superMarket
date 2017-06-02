package com.superMarket.employee.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.superMarket.baseFile.supplier.bean.Supplier;
import com.superMarket.baseFile.supplier.dao.SupplierDao;
import com.superMarket.baseFile.supplier.dao.SupplierDaoImpl;
import com.superMarket.employee.bean.Employee;
import com.superMarket.employee.dao.EmployeeDao;
import com.superMarket.employee.dao.EmployeeDaoImpl;

/**
 * 供货商表的tableModel
 * @author administrator
 *
 */

public class EmployeeTableModel extends AbstractTableModel  {
	private static final long serialVersionUID = 1L;
	private EmployeeDao dao = new EmployeeDaoImpl();
	private  List<Employee> data  = dao.getEmployeeList();
	
	/**
	 * 返回行数
	 */
	
	@Override
	public int getColumnCount() {
		
		return  11;
	}

	/**
	 * 返回列数
	 */
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		 Employee employee = data.get(rowIndex);
		if (columnIndex == 0)
			return employee.getId();
		else if (columnIndex == 1)
			return employee.getName();
		else if (columnIndex == 2)
			return employee.getAge();
		else if (columnIndex == 3)
			return employee.getSex();
		else if (columnIndex == 4)
			return employee.getDuty();
		else if (columnIndex == 5)
			return employee.getDepartment();
		else if (columnIndex == 6)
			return employee.getPhone();
		else if (columnIndex == 7)
			return employee.getOfficePhone();
		else if (columnIndex == 8)
			return employee.getFax();
		else if (columnIndex == 9)
			return employee.getEmail();
		else if (columnIndex == 10)
			return employee.getAddress();
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0)
			return "编号";
		else if (column == 1)
			return  "姓名";
		else if (column == 2)
			return  "年龄";
		else if (column == 3)
			return "性别";
		else if (column == 4)
			return  "职位";
		else if (column == 5)
			return  "部门";
		else if (column == 6)
			return  "联系电话";
		else if (column == 7)
			return  "工作电话";
		else if (column == 8)
			return  "传真";
		else if (column == 9)
			return  "e-mail";
		else if (column == 10)
			return  "地址";
		return "查询错误";
	}
	
	  public void setData(List<Employee> data) {
		    if (data == null)
		      throw new IllegalArgumentException("参数data不能为null。");
		    this.data = data;
		    fireTableDataChanged();
		  }
	  
}
