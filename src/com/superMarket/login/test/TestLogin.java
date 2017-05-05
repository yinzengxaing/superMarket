package com.superMarket.login.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.superMarket.login.bean.User;
import com.superMarket.login.dao.UserDao;
import com.superMarket.login.dao.impl.UserDaoImpl;
import com.superMarket.login.view.Login;

public class TestLogin {

	UserDao userDao = new UserDaoImpl();
	@Test
	public void test() {
		User user = new User("admin", "12313");
	User user2 = userDao.getUserByUsernameAndPassword(user);
		System.out.println(user2);
	}

	
}
