package com.superMarket.baseFile.supplier.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.superMarket.baseFile.supplier.bean.Supplier;
import com.superMarket.baseFile.supplier.dao.SupplierDao;
import com.superMarket.baseFile.supplier.dao.SupplierDaoImpl;
import com.superMarket.baseFile.supplier.model.SupplierTableModel;

public class SupplierPanel {

	private JPanel myPanel;//主界面
	private JTextField textField; //供应商名称输入框
	private JTextField textField_1; //地址输入框
	public  static JTable table;
	private JPanel supplierTableModel;
	private  SupplierTableModel model; 
	private SupplierDao dao = new  SupplierDaoImpl();
	public JPanel getSupplierPanel(){

		myPanel = new JPanel();
		
		myPanel.setLayout(null);
		myPanel.setSize(888, 500);
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel.setBounds(2, 4, 1000, 46);
		myPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("供货商名称：");
		label.setBounds(10, 21, 78, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(91, 18, 86, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("地址：");
		label_1.setBounds(187, 21, 54, 15);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(223, 18, 86, 21);
		panel.add(textField_1);
		
		JButton button_search = new JButton("搜索");
		button_search.setBounds(343, 17, 67, 23);
		panel.add(button_search);
		button_search.addActionListener(new SearchButtonListener());
		
		JButton button_add = new JButton("添加");
		button_add.setBounds(420, 17, 67, 23);
		panel.add(button_add);
		button_add.addActionListener(new AddButtonListener());

		
		JButton button_update = new JButton("修改");
		button_update.setBounds(501, 17, 67, 23);
		panel.add(button_update);
		button_update.addActionListener(new UpdateButtonListener());
		
		JButton button_delete = new JButton("删除");
		button_delete.setBounds(583, 17, 67, 23);
		panel.add(button_delete);
		button_delete.addActionListener(new DeleteButtonListener());
		
		supplierTableModel = new JPanel();
		supplierTableModel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		supplierTableModel.setBounds(2, 60, 1000, 550);
		myPanel.add(supplierTableModel);
		
		supplierTableModel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		supplierTableModel.add(scrollPane);
		model= new SupplierTableModel();
		table = new JTable(model);
		scrollPane.setViewportView(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder("供货商信息"));

		return myPanel;
		
	}
	
	/**
	 * 添加按钮监听器
	 * @author administrator
	 *
	 */
	public class AddButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			textField.setText("");
			textField_1.setText("");
		AddSupplierFrame addSuppliserFrame = new AddSupplierFrame();
		
		}
		
	}
	
	/**
	 * 删除按钮监听器
	 * @author administrator
	 *
	 */
	
	public class DeleteButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int row = table.getSelectedRow();
			String id = null;
			try{
			 id  = (String) table.getValueAt(row, 0);
			}catch (ArrayIndexOutOfBoundsException ex){
				System.out.println("未选择修改的列！");
			}
			if (id == null){
				 JOptionPane.showMessageDialog(null, "请选取需要删除的供货商！", "警告", JOptionPane.ERROR_MESSAGE);
				return;
				}
			
			
			//询问用户是否真的删除该供货商
			int isdel = JOptionPane.showConfirmDialog(null,
				       "是否确定删除该供货商？", "删除供货商？", JOptionPane.YES_NO_OPTION,
				       JOptionPane.WARNING_MESSAGE, null);
			if(isdel == 1)
				return;
			
			textField.setText("");
			textField_1.setText("");
			
			
			
			dao.delSuppliser(id);
			//table.removeAll();
			table.setModel(new SupplierTableModel());
			
		}
		
	}
	
	/**
	 * 搜索按钮监听器
	 * @author administrator
	 *
	 */
	public class SearchButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String name = textField.getText();
			String address = textField_1.getText();
			List<Supplier> list = null;
			if (name.equals("") && !address.equals("") ){
				list= dao.getSupplierListByAddress(address);
				if (list.isEmpty()){
					JOptionPane.showMessageDialog(null, "未查询到该关键字,请重试！", "警告", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					textField_1.setText("");
				return;	
				}
				table.removeAll();
				model.setData(list);
				table.setModel(model);
			}else if(!name.equals("") && address.equals("")){
				list = dao.getSupplierListByName(name);
				if (list.isEmpty()){
					JOptionPane.showMessageDialog(null, "未查询到该关键字,请重试！", "警告", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					textField_1.setText("");
				return;	
				}
				model.setData(list);
				table.setModel(model);
			}else if (!name.equals("") && !address.equals("")){
				list = dao.getSupplierListByAddressAndName(name, address);
				if (list.isEmpty()){
					JOptionPane.showMessageDialog(null, "未查询到该关键字,请重试！", "警告", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					textField_1.setText("");
				return;	
				}
				model.setData(list);
				table.setModel(model);
			}else if (name.equals("") && address.equals("")){
				list = dao.getSuppliserList();
				model.setData(list);
				table.setModel(model);
			}
			
		}
		
	}
	
	/**
	 * 更新按钮的监听器
	 * @author administrator
	 *
	 */
	public class UpdateButtonListener implements  ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
	
			
			//获取选取的行
			int row = table.getSelectedRow();
			//获取选取的id
			String id = null;
			try{
			id = (String) table.getValueAt(row, 0);
			}catch(ArrayIndexOutOfBoundsException ex){
				System.out.println("未选取修改的行");
			}
			
			if (id == null){
				 JOptionPane.showMessageDialog(null, "请选取需要修改的供货商！", "警告", JOptionPane.ERROR_MESSAGE);
				return;
				
			}
			textField.setText("");
			textField_1.setText("");
			//获取选取的供货商的信息
			Supplier supplier = dao.getSuppliserById(id);
			System.out.println("供货商信息"+supplier);
			//将信息传入修改页面
			UpdateSupplierFrame frame = new UpdateSupplierFrame(supplier);
			table.setModel(new SupplierTableModel());
			
		}
		
	}
	
	
	
}
