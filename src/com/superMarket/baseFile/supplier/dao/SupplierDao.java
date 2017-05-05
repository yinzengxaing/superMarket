package com.superMarket.baseFile.supplier.dao;

import java.util.ArrayList;
import java.util.List;

import com.superMarket.baseFile.supplier.bean.Supplier;

/**
 * 客户相关的dao 接口
 * @author administrator
 *
 */
public interface SupplierDao {
	
	/**
	 * 获取全部的供货商
	 * @return
	 */
	List<Supplier> getSuppliserList();
	
	/**
	 * 添加一个供货商
	 * @param supplier
	 * @return
	 */
	int addSuppliser (Supplier supplier);

	/**
	 * 根据id删除一个供货商
	 * @param id
	 * @return
	 */
	int delSuppliser (String id);
	
	/**
	 * 更新一个供货商信息
	 * @param supplier
	 * @return
	 */
	int upadteSupplier (Supplier supplier);
	
	/**
	 * 根据id 查询一个供货商
	 * @param id
	 * @return
	 */
	Supplier getSuppliserById(String id);
	
	/**
	 * 根据供货商名称 模糊查询一组供货商
	 * @return
	 */
	List<Supplier> getSupplierListByName(String name);
	
	/**
	 * 根据供货商地址模糊查询一组供货商
	 * @return
	 */
	List<Supplier> getSupplierListByAddress(String address); 
	
	/**
	 * 根据供货商地址和姓名模糊查询一组供货商
	 * @return
	 */
	
	List<Supplier> getSupplierListByAddressAndName(String name,String address);
 }
