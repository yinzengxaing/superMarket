package com.superMarket.baseFile.supplier.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.superMarket.baseFile.supplier.bean.Supplier;
import com.superMarket.baseFile.supplier.dao.SupplierDao;
import com.superMarket.baseFile.supplier.dao.SupplierDaoImpl;

public class TestSupplierDao {
	
	SupplierDao dao = new SupplierDaoImpl();
	

	@Test
	public void testGetSuppliserList() {
		List<Supplier> list = dao.getSuppliserList();
		
		for (Supplier supplier : list) {
			
			System.out.println(supplier);
		}
	}

	@Test
	public void testAddSuppliser() {
		
		Supplier supplier = new Supplier( null,"哇哈哈集团", "常州", "饮料", "张涛", "12545354", "54432", "5445354", "7872575864415", "www.wahaha.com", "zhangtao@163.com", "无");
		int i = dao.addSuppliser(supplier);
		System.out.println(i);
	}

	@Test
	public void testDelSuppliser() {
		int i = dao.delSuppliser("6");
		System.out.println(i);
	}

	@Test
	public void testUpadteSupplier() {
		Supplier supplier = new Supplier("11","哇集团", "常州", "饮料", "张涛", "12545354", "54432", "5445354", "7872575864415", "www.wahaha.com", "zhangtao@163.com", "无");
	
		int i = dao.upadteSupplier(supplier);
		System.out.println(i);
	}

	@Test
	public void testGetSuppliserById() {
		Supplier supplier = dao.getSuppliserById("7");
		
		System.out.println(supplier);
	}

	@Test
	public void testGetSupplierListByName() {
		List<Supplier> list = dao.getSupplierListByName("集团");
		
		for (Supplier supplier : list) {
			
			System.out.println(supplier);
		}
	}

	@Test
	public void testGetSupplierListByAddress() {
		List<Supplier> list = dao.getSupplierListByAddress("常州");
		
		for (Supplier supplier : list) {
			System.out.println(supplier);
		}
	}

}
