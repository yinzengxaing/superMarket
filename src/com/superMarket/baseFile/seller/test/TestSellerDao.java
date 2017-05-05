package com.superMarket.baseFile.seller.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.superMarket.baseFile.seller.bean.Seller;
import com.superMarket.baseFile.seller.dao.SellerDao;
import com.superMarket.baseFile.seller.dao.SellerDaoImpl;

public class TestSellerDao {

	private SellerDao dao = new SellerDaoImpl();
	@Test
	public void testGetSellerList() {
		List<Seller> list = dao.getSellerList();
		for (Seller seller : list) {
			System.out.println(seller);
		}
	}

	@Test
	public void testGetSellerById() {
		Seller seller = dao.getSellerById("27");
		System.out.println(seller);
	}

	@Test
	public void testGetSellerListByName() {
	List<Seller> list = dao.getSellerListByName("集团");
	for (Seller seller : list) {
		System.out.println(seller);
	}
	
	}

	@Test
	public void testGetSellerListByAddress() {
		List<Seller> list = dao.getSellerListByAddress("北京");
		for (Seller seller : list) {
			System.out.println(seller);
		}
	}

	@Test
	public void testGetSellerListByNameAndAddress() {
		List<Seller> list = dao.getSellerListByNameAndAddress("团", "北京");
		for (Seller seller : list) {
			System.out.println(list);
		}
	}

	@Test
	public void testAddSeller() {
		Seller seller = new Seller(null, "营销商A", "上海", "李明", "15445574", "15445574", "15445574", "15445574", "www.baidu.com", "15445574", "无");
		int i = dao.addSeller(seller);
		System.out.println(i);
	}

	@Test
	public void testDelSeller() {
	int i = dao.delSeller("26");
	System.out.println(i);
	}

	@Test
	public void testUpdateSeller() {
		Seller seller = new Seller("27", "营销商A", "上海", "张明", "15445574", "15445574", "15445574", "15445574", "www.baidu.com", "15445574", "无");
		int i = dao.updateSeller(seller);
		System.out.println(i);
	}

}
