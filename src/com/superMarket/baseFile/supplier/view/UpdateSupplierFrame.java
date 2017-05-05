package com.superMarket.baseFile.supplier.view;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.superMarket.baseFile.supplier.bean.Supplier;
import com.superMarket.baseFile.supplier.dao.SupplierDao;
import com.superMarket.baseFile.supplier.dao.SupplierDaoImpl;
import com.superMarket.baseFile.supplier.model.SupplierTableModel;
import java.awt.Color;

public class UpdateSupplierFrame {

	public  JFrame frame;
	private JTextField t_name;
	private JLabel label_1;
	private JTextField t_address;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField t_provide;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel lblEmail;
	private JLabel label_13;
	private JTextField t_linkman;
	private JTextField t_linkPhone;
	private JTextField t_faxes;
	private JTextField t_postNum;
	private JTextField t_bankNum;
	private JTextField t_netAddress;
	private JTextField t_emailAddress;
	private JTextArea t_remark ;
	
	private Supplier supplier;
	private SupplierDao dao = new SupplierDaoImpl();

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSuppliserFrame window = new AddSuppliserFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public UpdateSupplierFrame(Supplier supplier ) {
		this.supplier = supplier;
		initialize();
		//System.out.println("供货商信息"+supplier);

	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 600, 500);
		frame.setTitle("供货商添加");
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("供货商名称：");
		label.setBounds(57, 36, 85, 15);
		frame.getContentPane().add(label);
		
		t_name = new JTextField();
		t_name.setBounds(140, 33, 127, 21);
		frame.getContentPane().add(t_name);
		t_name.setColumns(10);
		
		label_1 = new JLabel("供货商地址：");
		label_1.setBounds(342, 36, 85, 15);
		frame.getContentPane().add(label_1);
		
		t_address = new JTextField();
		t_address.setColumns(10);
		t_address.setBounds(421, 33, 127, 21);
		frame.getContentPane().add(t_address);
		
		label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(278, 36, 16, 15);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setBounds(558, 36, 16, 15);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("产品：");
		label_4.setBounds(57, 78, 85, 15);
		frame.getContentPane().add(label_4);
		
		t_provide = new JTextField();
		t_provide.setColumns(10);
		t_provide.setBounds(140, 75, 127, 21);
		frame.getContentPane().add(t_provide);
		
		label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setBounds(278, 78, 16, 15);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("联系人：");
		label_6.setBounds(342, 78, 85, 15);
		frame.getContentPane().add(label_6);
		
		label_7 = new JLabel("联系电话：");
		label_7.setBounds(57, 122, 85, 15);
		frame.getContentPane().add(label_7);
		
		label_8 = new JLabel("传真：");
		label_8.setBounds(342, 122, 85, 15);
		frame.getContentPane().add(label_8);
		
		label_9 = new JLabel("邮编");
		label_9.setBounds(57, 165, 85, 15);
		frame.getContentPane().add(label_9);
		
		label_10 = new JLabel("银行账号：");
		label_10.setBounds(342, 165, 85, 15);
		frame.getContentPane().add(label_10);
		
		label_11 = new JLabel("网址：");
		label_11.setBounds(57, 206, 85, 15);
		frame.getContentPane().add(label_11);
		
		lblEmail = new JLabel("E-mail：");
		lblEmail.setBounds(342, 206, 85, 15);
		frame.getContentPane().add(lblEmail);
		
		label_13 = new JLabel("备注：");
		label_13.setBounds(57, 247, 85, 15);
		frame.getContentPane().add(label_13);
		
		t_linkman = new JTextField();
		t_linkman.setColumns(10);
		t_linkman.setBounds(421, 75, 127, 21);
		frame.getContentPane().add(t_linkman);
		
		t_linkPhone = new JTextField();
		t_linkPhone.setColumns(10);
		t_linkPhone.setBounds(140, 119, 127, 21);
		frame.getContentPane().add(t_linkPhone);
		
		t_faxes = new JTextField();
		t_faxes.setColumns(10);
		t_faxes.setBounds(421, 119, 127, 21);
		frame.getContentPane().add(t_faxes);
		
		t_postNum = new JTextField();
		t_postNum.setColumns(10);
		t_postNum.setBounds(140, 162, 127, 21);
		frame.getContentPane().add(t_postNum);
		
		t_bankNum = new JTextField();
		t_bankNum.setColumns(10);
		t_bankNum.setBounds(421, 162, 127, 21);
		frame.getContentPane().add(t_bankNum);
		
		t_netAddress = new JTextField();
		t_netAddress.setColumns(10);
		t_netAddress.setBounds(140, 203, 127, 21);
		frame.getContentPane().add(t_netAddress);
		
		t_emailAddress = new JTextField();
		t_emailAddress.setColumns(10);
		t_emailAddress.setBounds(421, 203, 127, 21);
		frame.getContentPane().add(t_emailAddress);
		
		t_remark = new JTextArea();
		t_remark.setBounds(138, 243, 410, 118);
		frame.getContentPane().add(t_remark);
		
		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setBounds(558, 81, 16, 15);
		frame.getContentPane().add(label_12);
		
		JLabel label_14 = new JLabel("*");
		label_14.setForeground(Color.RED);
		label_14.setBounds(278, 122, 16, 15);
		frame.getContentPane().add(label_14);
		
		JButton button_add = new JButton("更新");
		button_add.setBounds(201, 412, 93, 23);
		frame.getContentPane().add(button_add);
		button_add.addActionListener(new AddButtonListener());
		
		JButton button_esc = new JButton("退出");
		button_esc.setBounds(342, 412, 93, 23);
		frame.getContentPane().add(button_esc);
		button_esc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		//设置显示信息
		t_name.setText(supplier.getName());
		t_address.setText(supplier.getAddress());
		t_provide.setText(supplier.getProvide());
		t_linkman.setText(supplier.getLinkman());
		t_linkPhone.setText(supplier.getLinkPhone());
		t_faxes.setText(supplier.getFaxes());
		t_postNum.setText(supplier.getPostNum());
		t_bankNum.setText(supplier.getBankNum());
		t_netAddress.setText(supplier.getNetAddress());
		t_emailAddress.setText(supplier.getEmailAddress());
		t_remark.setText(supplier.getRemark());
	}
	




	public class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			 
			 String name = t_name.getText();
			 String address = t_address.getText();
			 String provide = t_provide.getText();
			 String linkman = t_linkman.getText();
			 String linkPhone = t_linkPhone.getText();
			 String faxes = t_faxes.getText();
			 String postNum = t_postNum.getText();
			 String bankNum = t_bankNum.getText();
			 String netAddress = t_netAddress.getText();
			 String emailAddress = t_emailAddress.getText();
			 String remark = t_remark.getText();
			 
			 Supplier new_supplier = new Supplier(supplier.getId(), name, address, provide, linkman, linkPhone, faxes, postNum, bankNum, netAddress, emailAddress, remark);
			 System.out.println(new_supplier);
			 int i = dao.upadteSupplier(new_supplier);
			 System.out.println(i);
			 SupplierPanel.table.removeAll();
			 SupplierPanel.table.setModel(new SupplierTableModel());
			 frame.setVisible(false);
			 
		}
		
	}
	
	
}
