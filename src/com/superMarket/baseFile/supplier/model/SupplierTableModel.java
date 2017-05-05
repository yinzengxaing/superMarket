package com.superMarket.baseFile.supplier.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.superMarket.baseFile.supplier.bean.Supplier;
import com.superMarket.baseFile.supplier.dao.SupplierDao;
import com.superMarket.baseFile.supplier.dao.SupplierDaoImpl;

/**
 * 供货商表的tableModel
 * @author administrator
 *
 */

public class SupplierTableModel extends AbstractTableModel  {
	private static final long serialVersionUID = 1L;
	private SupplierDao dao = new SupplierDaoImpl();
	private  List<Supplier> data  = dao.getSuppliserList();
	
	/**
	 * 返回行数
	 */
	
	@Override
	public int getColumnCount() {
		
		return  12;
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
		
		Supplier supplier = data.get(rowIndex);
		if (columnIndex == 0){
		//	System.out.println(supplier.getId());
			return supplier.getId();
		}
		if (columnIndex == 1)
			return supplier.getName();
		if (columnIndex == 2)
			return supplier.getAddress();
		if (columnIndex == 3)
			return supplier.getProvide();
		if (columnIndex == 4)
			return supplier.getLinkman();
		if (columnIndex == 5)
			return supplier.getLinkPhone();
		if (columnIndex == 6)
			return supplier.getFaxes();
		if (columnIndex == 7)
			return supplier.getPostNum();
		if (columnIndex == 8)
			return supplier.getBankNum();
		if (columnIndex == 9)
			return supplier.getNetAddress();
		if (columnIndex == 10)
			return supplier.getEmailAddress();
		if (columnIndex == 11)
			return supplier.getRemark();
		
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0)
			return "编号";
		if (column == 1)
			return  "供货商名称";
		if (column == 2)
			return  "供货商地址";
		if (column == 3)
			return "产品";
		if (column == 4)
			return  "联系人";
		if (column == 5)
			return  "联系电话";
		if (column == 6)
			return  "传真";
		if (column == 7)
			return  "邮编";
		if (column == 8)
			return  "银行账号";
		if (column == 9)
			return  "网址";
		if (column == 10)
			return  "E-mail";
		if (column == 11)
			return  "备注";
		return "查询错误";
	}
	
	  public void setData(List<Supplier> data) {
		    if (data == null)
		      throw new IllegalArgumentException("参数data不能为null。");
		    this.data = data;
		    fireTableDataChanged();
		  }
	  
}
