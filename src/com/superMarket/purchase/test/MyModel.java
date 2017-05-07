package com.superMarket.purchase.test;



import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.superMarket.baseFile.goods.bean.Goods;
import com.superMarket.baseFile.goods.dao.GoodsDao;
import com.superMarket.baseFile.goods.dao.GoodsDaoImpl;
import com.superMarket.purchase.bean.Purchase;
import com.superMarket.purchase.dao.PurchaseDao;
import com.superMarket.purchase.dao.PurchaseDaoImpl;

public class MyModel extends DefaultTableModel{
	private static final long serialVersionUID = 1L;
	private PurchaseDao  dao  = new  PurchaseDaoImpl();
	private  List<Purchase> data = new ArrayList<Purchase>();
	private int Column;;
	private int Row;
	
	
	public MyModel(int row ) {
			this.Row = row;
	}
	/**
	 * 测试数据
	 */
	{
		Purchase purchase = new Purchase("1", "aaa", "aaa", "2001-10-6", "aaa", 3, 66.6,0,0);
		Purchase purchase2 = new Purchase("2", "aaa", "aaa", "2001-10-6", "aaa", 3, 66.6,0,0);
		Purchase purchase3 = new Purchase("3", "aaa", "aaa", "2001-10-6", "aaa", 3, 66.6,0,0);
		Purchase purchase4 = new Purchase("4", "aaa", "aaa", "2001-10-6", "aaa", 3, 66.6,0,0);
		data.add(purchase);
		data.add(purchase2);
		data.add(purchase3);
		data.add(purchase4);
	}
	
	/**
	 * 返回列数
	 */
	@Override
	public int getColumnCount() {
		
		return  Column;
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
		Purchase purchase = data.get(rowIndex);
		if (columnIndex == 0){
			return purchase.getIsInStock();
		}
		if (columnIndex == 1)
			return purchase.getId();
		if (columnIndex == 2)
			return purchase.getsName();
		if (columnIndex == 3)
			return purchase.getOrderId();
		if (columnIndex == 4)
			return purchase.getConsignmentDate();
		if (columnIndex == 5)
			return purchase.getGoodsName();
		if (columnIndex == 6)
			return purchase.getMoney();
		if (columnIndex == 7)
			return purchase.getCount();
		if (columnIndex == 8)
			return purchase.getWarehouseId();
		
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0)
			return "是否入库";
		if (column == 1)
			return  "编号";
		if (column == 2)
			return  "客户";
		if (column == 3)
			return  "订单号";
		if (column == 4)
			return  "交货日期";
		if (column == 5)
			return  "商品名";
		if (column == 6)
			return  "金额";
		if (column == 7)
			return  "数量";
		if (column == 8)
			return  "所属库房";
		
		return "查询错误";
	}
	
	  public void setData(List<Purchase> data) {
		    if (data == null)
		      throw new IllegalArgumentException("参数data不能为null。");
		    this.data = data;
		    fireTableDataChanged();
		  }
}
