package com.superMarket.login.dao;

import com.superMarket.login.bean.User;
import com.superMarket.utils.BaseDao;

public class UserDaoImpl extends BaseDao<User>  implements UserDao {

	@Override
	public User getUserByUsernameAndPassword(User user) {
		
		String sql = "SELECT id , username , password FROM user WHERE username=? AND password=?" ;
		
		return  this.getBean(sql, user.getUsername(),user.getPassword());
		
	}

	

}
