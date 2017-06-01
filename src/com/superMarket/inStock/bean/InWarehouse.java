package com.superMarket.inStock.bean;
/**
 * 入库类
 * @author yinzengxaing
 *
 */
public class InWarehouse {
	private String id;
	private String orderId;
	private String warehouseId;
	private String goodsName;
	private String inDate;
	private double  weight;
	private String remark;
	public InWarehouse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InWarehouse(String id, String orderId, String warehouseId, String goodsName, String inDate, double weight,
			String remark) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.warehouseId = warehouseId;
		this.goodsName = goodsName;
		this.inDate = inDate;
		this.weight = weight;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "InWarehouse [id=" + id + ", orderId=" + orderId + ", warehouseId=" + warehouseId + ", goodsName="
				+ goodsName + ", inDate=" + inDate + ", weight=" + weight + ", remark=" + remark + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
}
