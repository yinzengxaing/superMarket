package com.superMarket.baseFile.seller.dao;

import java.util.List;

import com.superMarket.baseFile.seller.bean.Seller;

/**
 * 处理销售商的dao
 * @author administrator
 *
 */
public interface SellerDao {

	/**
	 * 获取一组销售商列表
	 * @return
	 */
	List<Seller> getSellerList();
	
	/**
	 * 通过id 获取单个销售商信息
	 * @param id
	 * @return
	 */
	Seller getSellerById(String id);
	
	/**
	 * 通过供货商姓名模糊查询一组销售商信息
	 * @param name
	 * @return
	 */
	List<Seller> getSellerListByName (String name);
	
	/**
	 * 通过地址模糊查询一组销售商信息
	 * @param address
	 * @return
	 */
	List<Seller> getSellerListByAddress(String address);
	
	/**
	 * 通过姓名和地址模糊查询一组销售商信息
	 * @param name
	 * @param address
	 * @return
	 */
	List<Seller> getSellerListByNameAndAddress(String name , String address);

	/**
	 * 添加一个销售商
	 * @param seller
	 * @return
	 */
	int addSeller(Seller seller);
	
	/**
	 * 删除一个销售商
	 * @param id
	 * @return
	 */
	int delSeller(String id);
	
	/**
	 * 更新一个销售商信息
	 * @param seller
	 * @return
	 */
	int updateSeller(Seller seller);
	
}
