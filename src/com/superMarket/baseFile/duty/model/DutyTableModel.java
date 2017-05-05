package com.superMarket.baseFile.duty.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.superMarket.baseFile.duty.bean.Duty;
import com.superMarket.baseFile.duty.dao.DutyDao;
import com.superMarket.baseFile.duty.dao.DutyDaoImpl;
import com.superMarket.baseFile.goods.bean.Goods;
import com.superMarket.baseFile.goods.dao.GoodsDao;
import com.superMarket.baseFile.goods.dao.GoodsDaoImpl;

public class DutyTableModel  extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private DutyDao dao  = new  DutyDaoImpl();
	private  List<Duty> data = dao.getDutyList();
	/**
	 * 返回列数
	 */
	@Override
	public int getColumnCount() {
		
		return  3;
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
		 Duty duty = data.get(rowIndex);
		if (columnIndex == 0){
			return duty.getId();
		}
		if (columnIndex == 1)
			return duty.getDutyName();
		if (columnIndex == 2)
			return duty.getDescription();
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0)
			return "编号";
		if (column == 1)
			return  "职务名称";
		if (column == 2)
			return  "职务描述";
		
		return "查询错误";
	}
	
	  public void setData(List<Duty> data) {
		    if (data == null)
		      throw new IllegalArgumentException("参数data不能为null。");
		    this.data = data;
		    fireTableDataChanged();
		  }
	
}
