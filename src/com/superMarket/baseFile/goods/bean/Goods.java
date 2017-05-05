package com.superMarket.baseFile.goods.bean;
/**
 * 货品的实体类
 * @author administrator
 *
 */
public class Goods {

	private String id;
	private String goodsName;//货品名
	private String goodsBewrite;//货品描述
	private String units; //计量单位
	private double stockPrice; //进货价格
	private double retailPrice;//零售价
	private double associatorPrice; //会员价
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsBewrite() {
		return goodsBewrite;
	}
	public void setGoodsBewrite(String goodsBewrite) {
		this.goodsBewrite = goodsBewrite;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public double getAssociatorPrice() {
		return associatorPrice;
	}
	public void setAssociatorPrice(double associatorPrice) {
		this.associatorPrice = associatorPrice;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodsName=" + goodsName + ", goodsBewrite=" + goodsBewrite + ", units=" + units
				+ ", stockPrice=" + stockPrice + ", retailPrice=" + retailPrice + ", associatorPrice=" + associatorPrice
				+ "]";
	}
	public Goods(String id, String goodsName, String goodsBewrite, String units, double stockPrice, double retailPrice,
			double associatorPrice) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.goodsBewrite = goodsBewrite;
		this.units = units;
		this.stockPrice = stockPrice;
		this.retailPrice = retailPrice;
		this.associatorPrice = associatorPrice;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
