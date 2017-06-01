package com.superMarket.outStock.dao;

import java.util.List;

import com.superMarket.outStock.bean.OutWarehouse;
import com.superMarket.utils.BaseDao;

public class OutWarehouseDaoImpl extends BaseDao<OutWarehouse>  implements OutWarehouseDao {

	@Override
	public List<OutWarehouse> getOutWarehouseList() {
		String sql = "select * from outwarehouse";
		return this.getBeanList(sql);
	}

	@Override
	public OutWarehouse getOutWarehouseById(String id) {
		String sql = "select * from outwarehouse where id = ?";
		return this.getBean(sql, id);
	}

	@Override
	public int addOutWarehouse(OutWarehouse outWarehouse) {
		String sql = "insert into outwarehouse (orderId, warehouseId, goodsName, outDate, weight,remark) values(?,?,?,?,?,?)";
		return this.update(sql, outWarehouse.getOrderId(),outWarehouse.getWarehouseId(),outWarehouse.getGoodsName(),outWarehouse.getOutDate(),outWarehouse.getWeight(),outWarehouse.getRemark());
	}

	@Override
	public int delOutWarehouse(String id) {
		String sql = "DELETE FROM outwarehouse WHERE id =? ";
		return this.update(sql, id);
	}

	@Override
	public int updateOutWarehouse(OutWarehouse outWarehouse) {
		String sql = "UPDATE outwarehouse SET orderId=?, warehouseId=?, goodsName=?, outDate=?, weight=?,remark=? where id = ?";
		return this.update(sql, outWarehouse.getOrderId(),outWarehouse.getWarehouseId(),outWarehouse.getGoodsName(),outWarehouse.getOutDate(),outWarehouse.getWeight(),outWarehouse.getRemark(),outWarehouse.getId());
	}

	@Override
	public List<OutWarehouse> selectOutwarehouseList(String orderId, String outDate) {
		
		orderId = "%"+orderId+"%";
		outDate = "%"+outDate+"%";
		String sql = "select * from outwarehouse where orderId like ? and outDate like ?";
		return this.getBeanList(sql, orderId,outDate);
	}

}
