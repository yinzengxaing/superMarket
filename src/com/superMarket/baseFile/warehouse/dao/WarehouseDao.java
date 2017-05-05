package com.superMarket.baseFile.warehouse.dao;

import java.util.List;

import com.superMarket.baseFile.warehouse.bean.Warehouse;

public interface WarehouseDao {

	/**
	 * 获取所有的仓库及库管信息
	 * @return
	 */
	List<Warehouse> getWarehouseList();
	
	/**
	 * 通过id 获取一个仓库
	 * @param id
	 * @return
	 */
	Warehouse getWarehouseById(String id);
	
	/**
	 * 通过负责人信息获取一组仓库
	 * @param principal
	 * @return
	 */
	List<Warehouse> getWarehouseListByPrincipal(String principal);
	
	/**
	 * 添加一个仓库
	 * @param warehouse
	 * @return
	 */
	
	int addWarehouse (Warehouse warehouse);
	
	/**
	 * 删除一个仓库
	 * @param id
	 * @return
	 */
	int delWarehouse (String id);
	
	/**
	 * 增加一个仓库
	 * @param warehouse
	 * @return
	 */
	int updateWarehouse(Warehouse warehouse);
	
	
}
