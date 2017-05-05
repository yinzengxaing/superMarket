package com.superMarket.baseFile.duty.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.superMarket.baseFile.duty.bean.Duty;
import com.superMarket.baseFile.duty.dao.DutyDao;
import com.superMarket.baseFile.duty.dao.DutyDaoImpl;

public class TestDutyDao {

	private DutyDao dao = new DutyDaoImpl();
	@Test
	public void testGetDutyList() {
	List<Duty> list = dao.getDutyList();
	for (Duty duty : list) {
		System.out.println(duty);
	}
	}

	@Test
	public void testGetDutyById() {
		Duty duty = dao.getDutyById("2");
		System.out.println(duty);
		
	}

	@Test
	public void testAddDuty() {
		Duty duty = new Duty(null, "经理", "主管超市各种事情");
		int i = dao.addDuty(duty);
		System.out.println(i);
	}

	@Test
	public void testDelDuty() {
		int i = dao.delDuty("1");
		System.out.println(i);
	}

	@Test
	public void testUpdateDuty() {
		Duty duty = new Duty("2", "经理", "负责管理超市各种事情");
		int i = dao.updateDuty(duty);
		System.out.println(i);
	}

}
