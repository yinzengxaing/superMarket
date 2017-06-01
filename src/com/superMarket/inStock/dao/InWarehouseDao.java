package com.superMarket.inStock.dao;

import java.util.List;

import com.superMarket.inStock.bean.InWarehouse;

public interface InWarehouseDao {
	
	public List<InWarehouse> getInWarehouseList();
	
	public InWarehouse getInWarehouseById(String id);
	
	public int addInWarehouse(InWarehouse inWarehouse);
	
	public int  delInWarehouse(String id);
	
	public int updateInWarehouse(InWarehouse inWarehouse);
	
	public List<InWarehouse> selectInwarehouseList(String orderId ,String inDate );
	
}
