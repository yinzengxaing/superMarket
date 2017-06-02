package com.superMarket.department.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.superMarket.baseFile.supplier.bean.Supplier;
import com.superMarket.baseFile.supplier.dao.SupplierDao;
import com.superMarket.baseFile.supplier.dao.SupplierDaoImpl;
import com.superMarket.baseFile.warehouse.bean.Warehouse;
import com.superMarket.baseFile.warehouse.dao.WarehouseDao;
import com.superMarket.baseFile.warehouse.dao.WarehouseDaoImpl;
import com.superMarket.department.bean.Department;
import com.superMarket.department.dao.DepartmentDao;
import com.superMarket.department.dao.DepartmentDaoImpl;

public class DepartmentTabelModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private DepartmentDao dao = new DepartmentDaoImpl();
	private  List<Department> data  = dao.getDepartmentList();
	
	/**
	 * 返回列数
	 */
	
	@Override
	public int getColumnCount() {
		
		return  4;
	}

	/**
	 * 返回行数
	 */
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		   Department department = data.get(rowIndex);
		if (columnIndex == 0)
			return department.getId();
		else if (columnIndex == 1)
			return department.getDepName();
		else if (columnIndex == 2)
			return department.getPrincipal();
		else if (columnIndex == 3)
			return department.getDescription();
	
		
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0)
			return "编号";
		if (column == 1)
			return  "职务名称";
		if (column == 2)
			return  "负责人";
		if (column == 3)
			return "描述";
		
		return "查询错误";
	}
	
	  public void setData(List<Department> data) {
		    if (data == null)
		      throw new IllegalArgumentException("参数data不能为null。");
		    this.data = data;
		    fireTableDataChanged();
		  }
	  
}
