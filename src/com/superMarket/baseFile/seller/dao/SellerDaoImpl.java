package com.superMarket.baseFile.seller.dao;

import java.util.List;

import com.superMarket.baseFile.seller.bean.Seller;
import com.superMarket.baseFile.supplier.bean.Supplier;
import com.superMarket.utils.BaseDao;

public class SellerDaoImpl extends BaseDao<Seller> implements SellerDao  {

	@Override
	public List<Seller> getSellerList() {
	
		String sql = "select * FROM seller";
		List<Seller> list = this.getBeanList(sql);
		return list;
	}

	@Override
	public Seller getSellerById(String id) {
		
		String sql ="SELECT * FROM seller WHERE id = ?";
		return this.getBean(sql, id);
	}

	@Override
	public List<Seller> getSellerListByName(String name) {
		name = "%"+name+"%";
		
		String sql = "SELECT * FROM seller WHERE name LIKE ?";
		
		List<Seller> list = this.getBeanList(sql,name );
		
		return list;
	}

	@Override
	public List<Seller> getSellerListByAddress(String address) {

		address = "%"+address+"%";
		
		String sql = "SELECT * FROM seller WHERE address LIKE ?";
		return  this.getBeanList(sql, address);
	}

	@Override
	public List<Seller> getSellerListByNameAndAddress(String name, String address) {
		name = "%"+name+"%";
		address = "%"+address+"%";
		
		String sql = "SELECT * FROM seller WHERE address LIKE ? AND name LIKE ?";
		return this.getBeanList(sql, address,name);
	}

	@Override
	public int addSeller(Seller seller) {
		
		String sql = "INSERT INTO seller (name,address,linkman,linkPhone,faxes,postNum,bankNum,netAddress,emailAddress,remark) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		int i = this.update(sql, seller.getName(),seller.getAddress(),seller.getLinkman(),seller.getLinkPhone(),seller.getFaxes(),
				seller.getPostNum(),seller.getBankNum(),seller.getNetAddress(),seller.getEmailAddress(),seller.getRemark());
			
			return i;
	}

	@Override
	public int delSeller(String id) {
		String sql = "DELETE FROM seller WHERE id=?";
		return  this.update(sql, id);
	}

	@Override
	public int updateSeller(Seller seller) {
		String sql = "UPDATE seller SET name=?,address=?,linkman=?,linkPhone=?,faxes=?,postNum=?,bankNum=?,netAddress=?,emailAddress=?,remark=? WHERE id=?";
		
		int i = this.update(sql, seller.getName(),seller.getAddress(),seller.getLinkman(),seller.getLinkPhone(),seller.getFaxes(),
				seller.getPostNum(),seller.getBankNum(),seller.getNetAddress(),seller.getEmailAddress(),seller.getRemark(),seller.getId());
			
			return i;
	}

}
