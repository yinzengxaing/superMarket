package com.superMarket.purchase.dao;

import java.util.List;

import com.superMarket.purchase.bean.Purchase;

public interface PurchaseDao {

	//获取全部计划采购商品
	List<Purchase> getPurchaseList();

	//获取一个计划采购商品信息
	Purchase getPurchaseById(String id);
	
	//通过客户名获取一组计划采购商品
	List<Purchase> getPurchaseListBySName(String sName);
	
	//通过商品名获取一组计划采购商品
	List<Purchase> getPurchaseListByGoodsName(String goodsName);
	
	//添加一个计划采购商品项
	int addPurchase(Purchase purchase);
	
	//删除一个计划采购商品项
	int delPurchase(String id);
	
	//修改一个计划采购商品项
	int updatePurchase(Purchase purchase);
	
	//对商品进行入库操作 warehouseId 为所入库房的库房编号
	int inStack(String id,String warehouseId);
	
	//修改入库状态
	int updateIsStack(String id);
	
	//获取所有的订单号
	List<Purchase> getAllOrderId(); 
	
	
	
}
