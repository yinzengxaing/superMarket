package com.superMarket.inStock.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.superMarket.baseFile.warehouse.bean.Warehouse;
import com.superMarket.baseFile.warehouse.dao.WarehouseDao;
import com.superMarket.baseFile.warehouse.dao.WarehouseDaoImpl;
import com.superMarket.inStock.bean.InWarehouse;
import com.superMarket.inStock.dao.InWarehouseDao;
import com.superMarket.inStock.dao.InWarehouseDaoImpl;
import com.superMarket.inStock.model.InWarehouseTableModel;
import com.superMarket.purchase.bean.Purchase;
import com.superMarket.purchase.dao.PurchaseDao;
import com.superMarket.purchase.dao.PurchaseDaoImpl;
import com.superMarket.purchase.test.DateChooserJButton;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;

public class addInWarehouseFrame {

	private JFrame frame;
	private JTextField goodsName_t;
	private JTextField weight_t;
	private JButton inDate_btn;
	private JComboBox orderIdBox, wearhouseIdBox ;
	private JTextArea remark_t;
	//获取订单号的dao
	private PurchaseDao purchaseDao = new PurchaseDaoImpl();
	//获取仓库的dao
	private WarehouseDao warehouseDao = new WarehouseDaoImpl();
	//获取入库的dao
	private InWarehouseDao inWarehouseDao = new InWarehouseDaoImpl();
	public addInWarehouseFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("添加入库");
		frame.setVisible(true);
		frame.setBounds(100, 100, 652, 488);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("订单号：");
		label.setBounds(47, 35, 54, 15);
		frame.getContentPane().add(label);
		
		orderIdBox = new JComboBox();
		orderIdBox.setBounds(111, 32, 119, 21);
		//添加数据
		List<Purchase> allOrderId = purchaseDao.getAllOrderId();
		for (Purchase purchase : allOrderId) {
			orderIdBox.addItem(purchase.getOrderId());
		}
		frame.getContentPane().add(orderIdBox);
		
		JLabel label_1 = new JLabel("仓库编号：");
		label_1.setBounds(333, 35, 66, 15);
		frame.getContentPane().add(label_1);
		
		wearhouseIdBox = new JComboBox();
		List<Warehouse> list = warehouseDao.getWarehouseList();
		for (Warehouse warehouse : list) {
			wearhouseIdBox.addItem(warehouse.getId());
		}
		wearhouseIdBox.setBounds(417, 32, 119, 21);
		frame.getContentPane().add(wearhouseIdBox);
		
		JLabel label_2 = new JLabel("货品名称：");
		label_2.setBounds(47, 116, 66, 15);
		frame.getContentPane().add(label_2);
		
		goodsName_t = new JTextField();
		goodsName_t.setBounds(111, 113, 119, 21);
		frame.getContentPane().add(goodsName_t);
		goodsName_t.setColumns(10);
		
		JLabel label_3 = new JLabel("入库时间：");
		label_3.setBounds(333, 116, 66, 15);
		frame.getContentPane().add(label_3);
		
		inDate_btn = new DateChooserJButton();
		inDate_btn.setBounds(417, 112, 131, 23);
		frame.getContentPane().add(inDate_btn);
		
		JLabel label_4 = new JLabel("货品重量：");
		label_4.setBounds(47, 207, 66, 15);
		frame.getContentPane().add(label_4);
		
		weight_t = new JTextField();
		weight_t.setColumns(10);
		weight_t.setBounds(111, 204, 72, 21);
		frame.getContentPane().add(weight_t);
		
		JLabel label_5 = new JLabel("千克");
		label_5.setBounds(193, 207, 54, 15);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("备注：");
		label_6.setBounds(47, 265, 36, 15);
		frame.getContentPane().add(label_6);
		
		remark_t = new JTextArea();
		remark_t.setBounds(93, 261, 364, 113);
		frame.getContentPane().add(remark_t);
		
		JButton addBtn = new JButton("添加");
		addBtn.setBounds(137, 404, 93, 23);
		addBtn.addActionListener(new addBtnListener());
		
		frame.getContentPane().add(addBtn);
		
		JButton button_2 = new JButton("退出");
		button_2.setBounds(333, 404, 93, 23);
		frame.getContentPane().add(button_2);
		
		JLabel lblNewLabel = new JLabel("*");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(240, 38, 17, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setBackground(Color.WHITE);
		label_7.setBounds(546, 35, 17, 15);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setBackground(Color.WHITE);
		label_8.setBounds(240, 119, 17, 15);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("*");
		label_9.setForeground(Color.RED);
		label_9.setBackground(Color.WHITE);
		label_9.setBounds(558, 116, 17, 15);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("*");
		label_10.setForeground(Color.RED);
		label_10.setBackground(Color.WHITE);
		label_10.setBounds(240, 207, 17, 15);
		frame.getContentPane().add(label_10);
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
	}

public class addBtnListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String orderId= orderIdBox.getSelectedItem().toString();
		String warehouseId = wearhouseIdBox.getSelectedItem().toString();
		String goodsName = goodsName_t.getText();
		String weightStr = weight_t.getText();
		String inDate = inDate_btn.getText();
		String remark = remark_t.getText();
		
		if (goodsName.equals("") || weightStr.equals("") ||  inDate.equals("") ){
			 JOptionPane.showMessageDialog(null, "请将入库信息补充完整！", "提示", JOptionPane.ERROR_MESSAGE);
			 return ;
		}
		double weight = 0.0;
			try {
				weight = Double.parseDouble(weightStr);
			} catch (NumberFormatException e1) {
				 JOptionPane.showMessageDialog(null, "请输入合法的数字！", "提示", JOptionPane.ERROR_MESSAGE);
				 weight_t.setText("");
				 return ;
			}
			InWarehouse inWarehouse = new InWarehouse(null, orderId, warehouseId, goodsName, inDate, weight, remark);
			inWarehouseDao.addInWarehouse(inWarehouse);
			InWarehousePanel.table.removeAll();
			InWarehousePanel.table.setModel(new InWarehouseTableModel());
			frame.setVisible(false);
	}
	
}
	
	
}
