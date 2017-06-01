package com.superMarket.inStock.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.superMarket.baseFile.duty.bean.Duty;
import com.superMarket.baseFile.duty.dao.DutyDao;
import com.superMarket.baseFile.duty.dao.DutyDaoImpl;
import com.superMarket.baseFile.goods.bean.Goods;
import com.superMarket.baseFile.goods.dao.GoodsDao;
import com.superMarket.baseFile.goods.dao.GoodsDaoImpl;
import com.superMarket.inStock.bean.InWarehouse;
import com.superMarket.inStock.dao.InWarehouseDao;
import com.superMarket.inStock.dao.InWarehouseDaoImpl;

public class InWarehouseTableModel  extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	InWarehouseDao dao = new InWarehouseDaoImpl();
	private  List<InWarehouse> data = dao.getInWarehouseList();
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
		InWarehouse inWarehouse = data.get(rowIndex);
		if (columnIndex == 0)
			return inWarehouse.getId();
		else if (columnIndex == 1)
			return inWarehouse.getOrderId();
		else if (columnIndex == 2)
			return inWarehouse.getWarehouseId();
		else if (columnIndex == 3)
			return inWarehouse.getGoodsName();
		else if (columnIndex == 4)
			return inWarehouse.getInDate();
		else if (columnIndex == 5)
			return inWarehouse.getWeight();
		else if (columnIndex == 6)
			return inWarehouse.getRemark();
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
			return  "入库时间";
		else if (column == 5)
			return  "重量";
		else if (column == 6)
			return  "备注";
		return "查询错误";
	}
	
	  public void setData(List<InWarehouse> data) {
		    if (data == null)
		      throw new IllegalArgumentException("参数data不能为null。");
		    this.data = data;
		    fireTableDataChanged();
		  }
	
}
