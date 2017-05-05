package com.superMarket.baseFile.warehouse.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.superMarket.baseFile.warehouse.bean.Warehouse;
import com.superMarket.baseFile.warehouse.dao.WarehouseDao;
import com.superMarket.baseFile.warehouse.dao.WarehouseDaoImpl;

public class TestWarehouseDao {
	private WarehouseDao dao = new WarehouseDaoImpl();
	@Test
	public void testGetWarehouseList() {
		List<Warehouse> list = dao.getWarehouseList();
		for (Warehouse warehouse : list) {
			System.out.println(warehouse);
		}
	}

	@Test
	public void testGetWarehouseById() {
		Warehouse warehouse = dao.getWarehouseById("1");
		System.out.println(warehouse);
	}

	@Test
	public void testGetWarehouseByPrincipal() {
		List<Warehouse> list = dao.getWarehouseListByPrincipal("黑");
		for (Warehouse warehouse : list) {
			System.out.println(warehouse);
		}
	}

	@Test
	public void testAddWarehouse() {
	
		Warehouse warehouse = new Warehouse(null,"酒水仓库", "小二黑", "酒水饮料放置地");
		Warehouse warehouse1 = new Warehouse(null,"粮油仓库", "小一黑", "粮油放置地");
		Warehouse warehouse2 = new Warehouse(null,"奶制品仓库", "小三黑", "奶制品放置地");
		Warehouse warehouse3 = new Warehouse(null,"食品仓库", "小四黑", " 食品放置地");
		
		//int i = dao.addWarehouse(warehouse);
		dao.addWarehouse(warehouse1);
		dao.addWarehouse(warehouse2);
		dao.addWarehouse(warehouse3);
		//System.out.println(i);
		
	}

	@Test
	public void testDelWarehouse() {
		int i = dao.delWarehouse("4");
		System.out.println(i);
	}

	@Test
	public void testUpdateWarehouse() {
		Warehouse warehouse = new Warehouse("3","酒水仓库", "小二黑的弟弟", "酒水饮料放置地");
		int i = dao.updateWarehouse(warehouse);
		System.out.println(i);
	}

}
