package com.superMarket.baseFile.duty.dao;

import java.util.List;

import com.superMarket.baseFile.duty.bean.Duty;
import com.superMarket.utils.BaseDao;

public class DutyDaoImpl extends BaseDao<Duty> implements DutyDao {

	@Override
	public List<Duty> getDutyList() {
	
		String sql = "select * from duty";
		
		return this.getBeanList(sql);
	}

	@Override
	public Duty getDutyById(String id) {
		String sql = "select * from duty where id = ?";
		return this.getBean(sql, id);
	}

	@Override
	public int addDuty(Duty duty) {
		String sql = "INSERT INTO duty (dutyName, description) VALUES(?,?)";
		return this.update(sql, duty.getDutyName(),duty.getDescription());
	}

	@Override
	public int delDuty(String id) {
		String sql = "DELETE FROM duty WHERE id =?";
		return this.update(sql, id);
	}

	@Override
	public int updateDuty(Duty duty) {
		String sql = "UPDATE duty SET dutyName=?,description=? WHERE id=? ";
		return  update(sql, duty.getDutyName(),duty.getDescription(),duty.getId());
	}

}
