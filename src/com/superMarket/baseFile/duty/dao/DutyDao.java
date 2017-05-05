package com.superMarket.baseFile.duty.dao;
/**
 * 处理职务的dao
 * @author administrator
 *
 */
import java.util.List;
import com.superMarket.baseFile.duty.bean.Duty;
public interface DutyDao {

	/**
	 * 获取一组职务列表
	 * @return
	 */
	List<Duty> getDutyList();
	
	/**
	 * 根据id 获取一个职务列表
	 * @param id
	 * @return
	 */
	Duty getDutyById(String id);
	
	/**
	 * 添加一个职务
	 * @param duty
	 * @return
	 */
	int addDuty(Duty duty);
	
	/**
	 * 删除一个职务
	 * @param id
	 * @return
	 */
	int delDuty(String id);
	
	/**
	 * 修改一个职务
	 * @param duty
	 * @return
	 */
	int updateDuty(Duty duty);
}
