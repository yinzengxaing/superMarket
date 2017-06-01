package com.superMarket.outStock.dao;

import java.util.List;

import com.superMarket.outStock.bean.OutWarehouse;

public interface OutWarehouseDao {
	
	public List<OutWarehouse> getOutWarehouseList();
	
	public OutWarehouse getOutWarehouseById(String id);
	
	public int addOutWarehouse(OutWarehouse outWarehouse);
	
	public int  delOutWarehouse(String id);
	
	public int updateOutWarehouse(OutWarehouse outWarehouse);
	
	public List<OutWarehouse> selectOutwarehouseList(String orderId ,String outDate );
	
}
