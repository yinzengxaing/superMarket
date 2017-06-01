package com.superMarket.outStock.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.superMarket.outStock.bean.OutWarehouse;
import com.superMarket.outStock.dao.OutWarehouseDao;
import com.superMarket.outStock.dao.OutWarehouseDaoImpl;

public class OutWarehouseTableModel  extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	OutWarehouseDao dao = new OutWarehouseDaoImpl();
	private  List<OutWarehouse> data = dao.getOutWarehouseList();
	/**
	 * 返回列数
	 */
	@Override
	public int getColumnCount() {
		
		return  7;
	}

	/**
	 * 返回数据个数
	 */
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		OutWarehouse outWarehouse = data.get(rowIndex);
		if (columnIndex == 0)
			return outWarehouse.getId();
		else if (columnIndex == 1)
			return outWarehouse.getOrderId();
		else if (columnIndex == 2)
			return outWarehouse.getWarehouseId();
		else if (columnIndex == 3)
			return outWarehouse.getGoodsName();
		else if (columnIndex == 4)
			return outWarehouse.getOutDate();
		else if (columnIndex == 5)
			return outWarehouse.getWeight();
		else if (columnIndex == 6)
			return outWarehouse.getRemark();
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0)
			return "编号";
		else if (column == 1)
			return  "订单号";
		else if (column == 2)
			return  "仓库编号";
		else if (column == 3)
			return  "货品名称";
		else if (column == 4)
			return  "出库时间";
		else if (column == 5)
			return  "重量";
		else if (column == 6)
			return  "备注";
		return "查询错误";
	}
	
	  public void setData(List<OutWarehouse> data) {
		    if (data == null)
		      throw new IllegalArgumentException("参数data不能为null。");
		    this.data = data;
		    fireTableDataChanged();
		  }
	
}
