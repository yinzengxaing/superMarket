package com.superMarket.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 获取和释放数据库连接的工具类
 * @author lilichao
 *
 */
public class JDBCUtils {
	
	private static DataSource dataSource = new ComboPooledDataSource("DataSource");
	
	/**
	 * 获取数据连接
	 * @return
	 */
	public static Connection getConnection(){
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 释放数据库连接的方法
	 * @param conn
	 */
	public static void releaseConnection(Connection conn){
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	

}
