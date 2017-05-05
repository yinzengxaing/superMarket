package com.superMarket.baseFile.goods.dao;

import java.util.List;

import com.superMarket.baseFile.goods.bean.Goods;
import com.superMarket.utils.BaseDao;

public class GoodsDaoImpl extends BaseDao<Goods> implements GoodsDao {

	@Override
	public List<Goods> getGoodsList() {

		String sql = "select * from goods";

		return this.getBeanList(sql);
	}

	@Override
	public List<Goods> getGoodsListByName(String goodsName) {
		goodsName = "%" + goodsName + "%";
		String sql = "select * from goods where goodsName LIKE ?";
		return this.getBeanList(sql, goodsName);
	}

	@Override
	public Goods getGoodById(String id) {
		String sql = "select * from goods where id = ?";
		return this.getBean(sql, id);
	}

	@Override
	public int addGoods(Goods goods) {
		String sql = "INSERT INTO goods (goodsName, goodsBewrite, units, stockPrice, retailPrice, associatorPrice )"
				+ "VALUES(?,?,?,?,?,?)";
		return this.update(sql, goods.getGoodsName(), goods.getGoodsBewrite(), goods.getUnits(), goods.getStockPrice(),
				goods.getRetailPrice(), goods.getAssociatorPrice());
	}

	@Override
	public int delGoods(String id) {
		String sql = "DELETE FROM goods WHERE id =?";
		return this.update(sql, id);
	}

	@Override
	public int updateGoods(Goods goods) {
		String sql = "UPDATE goods SET goodsName=?, goodsBewrite=?, units=?, stockPrice=?, retailPrice=?, associatorPrice=?  WHERE id=?";
		return this.update(sql, goods.getGoodsName(), goods.getGoodsBewrite(), goods.getUnits(), goods.getStockPrice(),
				goods.getRetailPrice(), goods.getAssociatorPrice(),goods.getId());
	}

}
