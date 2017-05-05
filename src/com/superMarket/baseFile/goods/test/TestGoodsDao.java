package com.superMarket.baseFile.goods.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.superMarket.baseFile.goods.bean.Goods;
import com.superMarket.baseFile.goods.dao.GoodsDao;
import com.superMarket.baseFile.goods.dao.GoodsDaoImpl;

public class TestGoodsDao {

	private GoodsDao dao = new GoodsDaoImpl(); 
	@Test
	public void testGetGoodsList() {
	List<Goods> list = dao.getGoodsList();
	for (Goods goods : list) {
		System.out.println(goods);
	}
	}

	@Test
	public void testGetGoodsListByName() {
		List<Goods> list = dao.getGoodsListByName("方便面");
		for (Goods goods : list) {
			System.out.println(goods);
		}
	}

	@Test
	public void testGetGoodById() {
	Goods goods = dao.getGoodById("3");
	System.out.println(goods);
	}

	@Test
	public void testAddGoods() {
		Goods goods = new Goods(null, "小涴熊方便面", "食品", "袋", 0.8, 1,0.9);
		Goods goods1 = new Goods(null, "海飞丝洗发露", "生活品", "瓶", 19.8, 25.3,22.6);
		Goods goods2 = new Goods(null, "美好时光海苔", "食品", "袋", 2.3, 3,2.6);
		Goods goods3 = new Goods(null, "手机", "超长待机", "部", 2350, 2700,2599);
		Goods goods4 = new Goods(null, "康师傅桶装方便面", "食品", "桶", 3, 4,3.5);
		int i = dao.addGoods(goods4);
		System.out.println(i);
	}

	@Test
	public void testDelGoods() {
	int i = dao.delGoods("4");
	System.out.println(i);
	}

	@Test
	public void testUpdateGoods() {
		
		Goods goods = new Goods("6", "康师傅桶装方便面", "食品", "桶", 3.01, 4,3.5);
		int i = dao.updateGoods(goods);
		System.out.println(i);
	}

}
