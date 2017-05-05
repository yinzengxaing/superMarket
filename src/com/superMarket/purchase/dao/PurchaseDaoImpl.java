package com.superMarket.purchase.dao;

import java.util.List;

import com.superMarket.purchase.bean.Purchase;
import com.superMarket.utils.BaseDao;

public class PurchaseDaoImpl extends BaseDao<Purchase> implements PurchaseDao {

	@Override
	public List<Purchase> getPurchaseList() {
		String sql = "select * from  stock";
		return this.getBeanList(sql);
	}

	@Override
	public Purchase getPurchaseById(String id) {
		
		String sql = "select * from stock where id=?";
		
		return this.getBean(sql, id);
	}

	@Override
	public List<Purchase> getPurchaseListBySName(String sName) {
		
		String sql = "select * from stock where sName like ?";
		
		return this.getBeanList(sql, sName);
	}

	@Override
	public List<Purchase> getPurchaseListByGoodsName(String goodsName) {
		
		String sql = "select * from stock where goodsName like ? ";
		
		return this.getBeanList(sql, goodsName);
	}

	@Override
	public int addPurchase(Purchase purchase) {
		
		String sql = "INSERT INTO stock (sName, orderId, consignmentDate, goodsNsme, count, money, isInStock,warehouseId) VALUES (?,?,?,?,?,?,?,?)";
		
		return this.update(sql, purchase.getsName(), purchase.getOrderId(), purchase.getConsignmentDate(),purchase.getGoodsNsme(),purchase.getCount(),purchase.getIsInStock(),purchase.getWarehouseId());
	}

	@Override
	public int delPurchase(String id) {
		
		String sql = "DELETE FROM stock  WHERE id = ?"; 
		
		return this.update(sql, id);
	}

	@Override
	public int updatePurchase(Purchase purchase) {
		String sql = "UPDATE stock  SET sName=?, orderId=?, consignmentDate=?, goodsNsme=?, count=?, money=?, isInStock=?,warehouseId=? where id=? ";
		return this.update(sql,purchase.getsName(), purchase.getOrderId(), purchase.getConsignmentDate(),purchase.getGoodsNsme(),purchase.getCount(),purchase.getIsInStock(),purchase.getWarehouseId(),purchase.getId() );
	}

	@Override
	public int inStack(String id,String warehouseId) {
		String sql = "UPDATE stock SET  warehouseId=? where id=? ";
		return this.update(sql, warehouseId,id);
	}

}
