package com.superMarket.purchase.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.superMarket.baseFile.seller.bean.Seller;
import com.superMarket.baseFile.seller.dao.SellerDao;
import com.superMarket.baseFile.seller.dao.SellerDaoImpl;
import com.superMarket.baseFile.warehouse.bean.Warehouse;
import com.superMarket.baseFile.warehouse.dao.WarehouseDao;
import com.superMarket.baseFile.warehouse.dao.WarehouseDaoImpl;
import com.superMarket.purchase.bean.Purchase;
import com.superMarket.purchase.dao.PurchaseDao;
import com.superMarket.purchase.dao.PurchaseDaoImpl;

public class PurchaseTableModel extends DefaultTableModel{

	private static final long serialVersionUID = 1L;
	private PurchaseDao dao = new PurchaseDaoImpl();
	private  List<Purchase> data = null ;
	private WarehouseDao warehouseDao = new WarehouseDaoImpl();
	private int row ;
	
	public PurchaseTableModel() {
		this.data  = dao.getPurchaseList();
		this.row = data.size();
	}
	
	public PurchaseTableModel(List<Purchase> data) {
		this.data  = data;
		this.row = data.size();
	}
	
	
	@Override
	public int getColumnCount() {
		
		return  9;
	}

	/**
	 * 返回列数
	 */
	@Override
	public int getRowCount() {
		return row;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		   Purchase purchase = data.get(rowIndex);
		   
		if (columnIndex == 0){
			if ( purchase.getIsInStock() == 0){
				return "未入库";
				}else{
				return "已入库";
				}
			}

		if (columnIndex == 1)
			return purchase.getId();
		if (columnIndex == 2){
			return purchase.getsName();
		}
		if (columnIndex == 3)
			return purchase.getOrderId();
		if (columnIndex == 4)
			return purchase.getConsignmentDate();
		if (columnIndex == 5)
			return purchase.getGoodsName();
		if (columnIndex == 6)
			return purchase.getCount();
		if (columnIndex == 7)
			return purchase.getMoney();
		if (columnIndex == 8){
			if (purchase.getWarehouseId() == -1)
			return "尚未分配库房";
			else{
				int id = purchase.getWarehouseId();
				Warehouse warehouse = warehouseDao.getWarehouseById(id+"");
				return warehouse.getName();
			}
		}
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
			return  "数量";
		if (column == 7)
			return  "金额";
		if (column == 8)
			return  "库房";
		return "查询错误";
	}
	
	  public void setData(List<Purchase> data) {
		
		    this.data = data;
		    System.out.println(data);
		    data.size();
		    
		    fireTableDataChanged();
		  }
	  
	  /**
	   * 设置表格不可被编辑
	   */
	  public boolean isCellEditable(int row, int column) {
		  if (column == 0 && this.getValueAt(row, 0).equals("未入库")){
			  return true;
		  }else{
          return false;
		  }
      }
}
