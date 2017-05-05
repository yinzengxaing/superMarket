package com.superMarket.baseFile.seller.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.superMarket.baseFile.seller.bean.Seller;
import com.superMarket.baseFile.seller.dao.SellerDao;
import com.superMarket.baseFile.seller.dao.SellerDaoImpl;

public class SellerTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private SellerDao dao = new SellerDaoImpl();
	private  List<Seller> data  = dao.getSellerList();
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
		 Seller seller = data.get(rowIndex);
		if (columnIndex == 0){
			return seller.getId();
		}
		if (columnIndex == 1)
			return seller.getName();
		if (columnIndex == 2)
			return seller.getAddress();
		if (columnIndex == 3)
			return seller.getLinkman();
		if (columnIndex == 4)
			return seller.getLinkPhone();
		if (columnIndex == 5)
			return seller.getFaxes();
		if (columnIndex == 6)
			return seller.getPostNum();
		if (columnIndex == 7)
			return seller.getBankNum();
		if (columnIndex == 8)
			return seller.getNetAddress();
		if (columnIndex == 9)
			return seller.getEmailAddress();
		if (columnIndex == 10)
			return seller.getRemark();
		
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0)
			return "编号";
		if (column == 1)
			return  "销售商名称";
		if (column == 2)
			return  "销售商地址";
		if (column == 3)
			return  "联系人";
		if (column == 4)
			return  "联系电话";
		if (column == 5)
			return  "传真";
		if (column == 6)
			return  "邮编";
		if (column == 7)
			return  "银行账号";
		if (column == 8)
			return  "网址";
		if (column == 9)
			return  "E-mail";
		if (column == 10)
			return  "备注";
		return "查询错误";
	}
	
	  public void setData(List<Seller> data) {
		    if (data == null)
		      throw new IllegalArgumentException("参数data不能为null。");
		    this.data = data;
		    fireTableDataChanged();
		  }
}
