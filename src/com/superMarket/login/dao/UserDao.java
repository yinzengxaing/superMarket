package com.superMarket.login.dao;

import com.superMarket.login.bean.User;

public interface UserDao {

	/**
	 * 查询一个用户
	 * @param user
	 * @return
	 */
	User getUserByUsernameAndPassword(User user);
	
	
	
}
