package com.superMarket.baseFile.goods.dao;

import java.util.List;

import com.superMarket.baseFile.goods.bean.Goods;

/**
 * 商品的dao
 * @author administrator
 *
 */

public interface GoodsDao {

	/**
	 * 获取所有的商品
	 * @return
	 */
	List<Goods> getGoodsList();
	
	/**
	 * 通过名字模糊查询获取一组商品
	 * @return
	 */
	List<Goods> getGoodsListByName(String goodsName);
	
	/**
	 * 通过id 获取一个商品
	 * @param id
	 * @return
	 */
	Goods getGoodById(String id);
	
	/**
	 * 添加一个商品
	 * @param goods
	 * @return
	 */
	int addGoods(Goods goods);
	
	/**
	 * 删除一个商品
	 * @param id
	 * @return
	 */
	int delGoods(String id);
	
	/**
	 * 更新一个商品
	 * @param goods
	 * @return
	 */
	int updateGoods(Goods goods);
}
