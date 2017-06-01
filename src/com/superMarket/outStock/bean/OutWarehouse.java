package com.superMarket.outStock.bean;

public class OutWarehouse {
	private String id;
	private String orderId;
	private String warehouseId;
	private String goodsName;
	private String outDate;
	private double  weight;
	private String remark;
	@Override
	public String toString() {
		return "OutWarehouse [id=" + id + ", orderId=" + orderId + ", warehouseId=" + warehouseId + ", goodsName="
				+ goodsName + ", outDate=" + outDate + ", weight=" + weight + ", remark=" + remark + "]";
	}
	public OutWarehouse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OutWarehouse(String id, String orderId, String warehouseId, String goodsName, String outDate, double weight,
			String remark) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.warehouseId = warehouseId;
		this.goodsName = goodsName;
		this.outDate = outDate;
		this.weight = weight;
		this.remark = remark;
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
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
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
