package com.superMarket.inStock.dao;

import java.util.List;

import com.superMarket.inStock.bean.InWarehouse;
import com.superMarket.utils.BaseDao;

public class InWarehouseDaoImpl extends BaseDao<InWarehouse> implements InWarehouseDao{

	@Override
	public List<InWarehouse> getInWarehouseList() {
		String sql = "select * from inwarehouse";
		return this.getBeanList(sql);
	}

	@Override
	public InWarehouse getInWarehouseById(String id) {
		String sql = "select * from inwarehouse where id = ?";
		return this.getBean(sql, id);
	}

	@Override
	public int addInWarehouse(InWarehouse inWarehouse) {
		String sql = "insert into inwarehouse (orderId, warehouseId, goodsName, inDate, weight,remark) values(?,?,?,?,?,?)";
		return this.update(sql, inWarehouse.getOrderId(),inWarehouse.getWarehouseId(),inWarehouse.getGoodsName(),inWarehouse.getInDate(),inWarehouse.getWeight(),inWarehouse.getRemark());
	}

	@Override
	public int delInWarehouse(String id) {
		String sql = "DELETE FROM inwarehouse WHERE id =? ";
		return this.update(sql, id);
	}

	@Override
	public int updateInWarehouse(InWarehouse inWarehouse) {
		String sql = "UPDATE inwarehouse SET orderId=?, warehouseId=?, goodsName=?, inDate=?, weight=?,remark=? where id = ?";
		return this.update(sql, inWarehouse.getOrderId(),inWarehouse.getWarehouseId(),inWarehouse.getGoodsName(),inWarehouse.getInDate(),inWarehouse.getWeight(),inWarehouse.getRemark(),inWarehouse.getId());

	}

	@Override
	public List<InWarehouse> selectInwarehouseList(String orderId ,String inDate) {
		
		orderId = "%"+orderId+"%";
		inDate = "%"+inDate+"%";
		String sql = "select * from inwarehouse where orderId like ? and inDate like ?";
		return this.getBeanList(sql, orderId,inDate);
	}

}
