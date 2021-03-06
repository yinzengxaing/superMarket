package com.superMarket.purchase.bean;

public class Purchase {

	private String id;
	private String sName;
	private String orderId;
	private String consignmentDate;//交货日期
	private String goodsName;
	private int count;
	private Double money;
	private int isInStock = 0; //0：未入库  1：入库 初始为 未入库
	private int warehouseId = -1 ; //所属库房编号 ， 未入库的情况下所属库房编号为-1;
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Purchase(String id, String sName, String orderId, String consignmentDate, String goodsName, int count,
			Double money, int isInStock, int warehouseId) {
		super();
		this.id = id;
		this.sName = sName;
		this.orderId = orderId;
		this.consignmentDate = consignmentDate;
		this.goodsName = goodsName;
		this.count = count;
		this.money = money;
		this.isInStock = isInStock;
		this.warehouseId = warehouseId;
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", sName=" + sName + ", orderId=" + orderId + ", consignmentDate="
				+ consignmentDate + ", goodsName=" + goodsName + ", count=" + count + ", money=" + money
				+ ", isInStock=" + isInStock + ", warehouseId=" + warehouseId + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getConsignmentDate() {
		return consignmentDate;
	}
	public void setConsignmentDate(String consignmentDate) {
		this.consignmentDate = consignmentDate;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public int getIsInStock() {
		return isInStock;
	}
	public void setIsInStock(int isInStock) {
		this.isInStock = isInStock;
	}
	public int getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	
	
	
}
