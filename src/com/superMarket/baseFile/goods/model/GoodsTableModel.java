package com.superMarket.baseFile.goods.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.superMarket.baseFile.goods.bean.Goods;
import com.superMarket.baseFile.goods.dao.GoodsDao;
import com.superMarket.baseFile.goods.dao.GoodsDaoImpl;

public class GoodsTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private GoodsDao dao  = new  GoodsDaoImpl();
	private  List<Goods> data = dao.getGoodsList();
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
		  Goods goods = data.get(rowIndex);
		if (columnIndex == 0){
			return goods.getId();
		}
		if (columnIndex == 1)
			return goods.getGoodsName();
		if (columnIndex == 2)
			return goods.getGoodsBewrite();
		if (columnIndex == 3)
			return goods.getUnits();
		if (columnIndex == 4)
			return goods.getStockPrice();
		if (columnIndex == 5)
			return goods.getRetailPrice();
		if (columnIndex == 6)
			return goods.getAssociatorPrice();
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0)
			return "编号";
		if (column == 1)
			return  "货品名称";
		if (column == 2)
			return  "货品描述";
		if (column == 3)
			return  "单位";
		if (column == 4)
			return  "进货价";
		if (column == 5)
			return  "零售价";
		if (column == 6)
			return  "会员价";
		
		return "查询错误";
	}
	
	  public void setData(List<Goods> data) {
		    if (data == null)
		      throw new IllegalArgumentException("参数data不能为null。");
		    this.data = data;
		    fireTableDataChanged();
		  }
}
