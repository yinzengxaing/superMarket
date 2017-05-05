package com.superMarket.baseFile.warehouse.dao;

import java.util.List;

import com.superMarket.baseFile.warehouse.bean.Warehouse;
import com.superMarket.utils.BaseDao;

public class WarehouseDaoImpl extends BaseDao<Warehouse> implements WarehouseDao {

	@Override
	public List<Warehouse> getWarehouseList() {
		
		String  sql ="select * from warehouse ";
		
		return this.getBeanList(sql);
	}

	@Override
	public Warehouse getWarehouseById(String id) {
		
		String sql = "select * from warehouse where id = ?";
		
		return this.getBean(sql, id);
	}

	@Override
	public List<Warehouse> getWarehouseListByPrincipal(String principal) {
		
		 principal = "%"+ principal+"%";
		
		String sql = "select * from warehouse where principal LIKE ? ";
		return this.getBeanList(sql, principal);
	}

	@Override
	public int addWarehouse(Warehouse warehouse) {

		String sql = "INSERT INTO warehouse (name, principal, bewrite) VALUES (?,?,?)";
		
		return this.update(sql, warehouse.getName(), warehouse.getPrincipal(),warehouse.getBewrite());
	}

	@Override
	public int delWarehouse(String id) {
		String sql ="DELETE FROM warehouse WHERE id = ?";
		return this.update(sql, id);
	}

	@Override
	public int updateWarehouse(Warehouse warehouse) {
		String sql="UPDATE warehouse SET name=?, principal=?, bewrite=? where id=?";
		return this.update(sql, warehouse.getName(), warehouse.getPrincipal(), warehouse.getBewrite(),warehouse.getId());
		
	}

}
