package com.superMarket.baseFile.warehouse.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.superMarket.baseFile.supplier.bean.Supplier;
import com.superMarket.baseFile.supplier.dao.SupplierDao;
import com.superMarket.baseFile.supplier.dao.SupplierDaoImpl;
import com.superMarket.baseFile.warehouse.bean.Warehouse;
import com.superMarket.baseFile.warehouse.dao.WarehouseDao;
import com.superMarket.baseFile.warehouse.dao.WarehouseDaoImpl;

public class WarehouseTabelModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private WarehouseDao dao = new WarehouseDaoImpl();
	private  List<Warehouse> data  = dao.getWarehouseList();
	
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
		
		  Warehouse warehouse = data.get(rowIndex);
		if (columnIndex == 0){
		//	System.out.println(supplier.getId());
			return warehouse.getId();
		}
		if (columnIndex == 1)
			return warehouse.getName();
		if (columnIndex == 2)
			return warehouse.getPrincipal();
		if (columnIndex == 3)
			return warehouse.getBewrite();
	
		
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0)
			return "编号";
		if (column == 1)
			return  "仓库名称";
		if (column == 2)
			return  "负责人";
		if (column == 3)
			return "仓库描述";
		
		return "查询错误";
	}
	
	  public void setData(List<Warehouse> data) {
		    if (data == null)
		      throw new IllegalArgumentException("参数data不能为null。");
		    this.data = data;
		    fireTableDataChanged();
		  }
	  
}
