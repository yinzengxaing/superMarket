package com.superMarket.baseFile.warehouse.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.superMarket.baseFile.warehouse.bean.Warehouse;
import com.superMarket.baseFile.warehouse.dao.WarehouseDao;
import com.superMarket.baseFile.warehouse.dao.WarehouseDaoImpl;
import com.superMarket.baseFile.warehouse.model.WarehouseTabelModel;

public class UpdateWarehouseFrame {
	public  JFrame frame;
	private JTextField t_principal;
	private JLabel label_2;
	private JLabel label_13;
	private JTextArea t_bewrite ;
	private Warehouse warehouse;
	
	private WarehouseDao dao = new WarehouseDaoImpl();
	private JTextField t_name;
	
	public UpdateWarehouseFrame(Warehouse warehouse ) {

		this.warehouse = warehouse;
		
		initialize();
	}
	
	

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 600, 373);
		frame.setTitle("供货商添加");
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("库管：");
		label.setBounds(335, 36, 45, 15);
		frame.getContentPane().add(label);
		
		t_principal = new JTextField();
		t_principal.setBounds(381, 33, 127, 21);
		frame.getContentPane().add(t_principal);
		t_principal.setColumns(10);
		
		label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(534, 36, 16, 15);
		frame.getContentPane().add(label_2);
		
		label_13 = new JLabel("仓库描述：");
		label_13.setBounds(67, 122, 85, 15);
		frame.getContentPane().add(label_13);
		
		t_bewrite = new JTextArea();
		t_bewrite.setBounds(140, 118, 410, 118);
		frame.getContentPane().add(t_bewrite);
		
		JButton button_add = new JButton("修改");
		button_add.setBounds(174, 274, 93, 23);
		frame.getContentPane().add(button_add);
		button_add.addActionListener(new AddButtonListener());
		
		JButton button_esc = new JButton("退出");
		button_esc.setBounds(334, 274, 93, 23);
		frame.getContentPane().add(button_esc);
		
		t_name = new JTextField();
		t_name.setColumns(10);
		t_name.setBounds(149, 33, 127, 21);
		frame.getContentPane().add(t_name);
		
		JLabel labe_2 = new JLabel("仓库名称：");
		labe_2.setBounds(67, 36, 85, 15);
		frame.getContentPane().add(labe_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setBounds(286, 36, 16, 15);
		frame.getContentPane().add(label_3);
		button_esc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
				
			}
		});
		
		//填充数据
		t_name.setText(warehouse.getName());
		t_principal.setText(warehouse.getPrincipal());
		t_bewrite.setText(warehouse.getBewrite());

	
	}
	
	public class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			 String principal = t_principal.getText();
			 String bewrite = t_bewrite.getText();
			 String name = t_name.getText();
			 String id = warehouse.getId();
			 
			 
			 //System.out.println(name+"name");
			 
			 if (name.equals("") || principal.equals("") ){
				 JOptionPane.showMessageDialog(null, "请将供货商信息补充完整！", "提示", JOptionPane.ERROR_MESSAGE);
				 return ;
			 }
			 
			 Warehouse new_warehouse  = new Warehouse(id, name, principal, bewrite);
			 dao.updateWarehouse(new_warehouse);
			WarehousePanel.table.setModel(new WarehouseTabelModel());
			 frame.setVisible(false);
			 
		}
		
	}
}
