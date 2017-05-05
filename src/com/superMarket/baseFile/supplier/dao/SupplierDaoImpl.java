package com.superMarket.baseFile.supplier.dao;

import java.util.List;

import com.superMarket.baseFile.supplier.bean.Supplier;
import com.superMarket.utils.BaseDao;

public class SupplierDaoImpl extends BaseDao<Supplier> implements SupplierDao {

	@Override
	public List<Supplier> getSuppliserList() {
		
		String sql = "select * FROM supplier";
		List<Supplier> suppliserList = this.getBeanList(sql);
		
		return suppliserList;
	}

	@Override
	public int addSuppliser(Supplier supplier) {
	String sql = "INSERT INTO supplier (name,address,provide,linkman,linkPhone,faxes,postNum,bankNum,netAddress,emailAddress,remark) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	int i = this.update(sql, supplier.getName(),supplier.getAddress(),supplier.getProvide(),supplier.getLinkman(),supplier.getLinkPhone(),supplier.getFaxes(),
				supplier.getPostNum(),supplier.getBankNum(),supplier.getNetAddress(),supplier.getEmailAddress(),supplier.getRemark());
		
		return i;
	}

	@Override
	public int delSuppliser(String id) {
		String sql = "DELETE FROM supplier WHERE id=?";
		return  this.update(sql, id);
	}

	@Override
	public int upadteSupplier(Supplier supplier) {
		String sql = "UPDATE supplier SET name=?,address=?,provide=?,linkman=?,linkPhone=?,faxes=?,postNum=?,bankNum=?,netAddress=?,emailAddress=?,remark=? WHERE id=?";
		
		return this.update(sql,supplier.getName(),supplier.getAddress(),supplier.getProvide(),supplier.getLinkman(),supplier.getLinkPhone(),supplier.getFaxes(),
				supplier.getPostNum(),supplier.getBankNum(),supplier.getNetAddress(),supplier.getEmailAddress(),supplier.getRemark(),supplier.getId());
		
	}

	@Override
	public Supplier getSuppliserById(String id) {

		String sql ="SELECT * FROM supplier WHERE id = ?";
		
		return this.getBean(sql, id) ;
	}

	@Override
	public List<Supplier> getSupplierListByName(String name) {
		
		name = "%"+name+"%";
		
		String sql = "SELECT * FROM supplier WHERE name LIKE ?";
		
		List<Supplier> list = this.getBeanList(sql,name );
		
		return list;
	}

	@Override
	public List<Supplier> getSupplierListByAddress(String address) {
		
		address = "%"+address+"%";
		
		String sql = "SELECT * FROM supplier WHERE address LIKE ?";
		return  this.getBeanList(sql, address);
	}

	@Override
	public List<Supplier> getSupplierListByAddressAndName(String name,String address) {
		name = "%"+name+"%";
		address = "%"+address+"%";
		
		String sql = "SELECT * FROM supplier WHERE address LIKE ? AND name LIKE ?";
		return this.getBeanList(sql, address,name);
	}

}
