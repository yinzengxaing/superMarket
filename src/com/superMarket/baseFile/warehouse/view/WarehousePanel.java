package com.superMarket.baseFile.warehouse.view;

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

import com.superMarket.baseFile.supplier.bean.Supplier;
import com.superMarket.baseFile.supplier.view.AddSupplierFrame;
import com.superMarket.baseFile.warehouse.bean.Warehouse;
import com.superMarket.baseFile.warehouse.dao.WarehouseDao;
import com.superMarket.baseFile.warehouse.dao.WarehouseDaoImpl;
import com.superMarket.baseFile.warehouse.model.WarehouseTabelModel;

public class WarehousePanel {

	private JPanel myPanel;//主界面
	private JTextField textField; //供应商名称输入框
	private JTextField textField_1; //地址输入框
	public  static JTable table;
	private JPanel tablePanel;
	private  WarehouseTabelModel model; 
	private  WarehouseDao dao = new WarehouseDaoImpl();
	public JPanel getWarehousePanel(){

		myPanel = new JPanel();
		
		myPanel.setLayout(null);
		myPanel.setSize(888, 500);
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel.setBounds(2, 4, 1000, 46);
		myPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("仓库编号：");
		label.setBounds(10, 21, 78, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(91, 18, 86, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("库管：");
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
		
		tablePanel = new JPanel();
		tablePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tablePanel.setBounds(2, 60, 1000, 550);
		myPanel.add(tablePanel);
		
		tablePanel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		tablePanel.add(scrollPane);
		model= new WarehouseTabelModel();
		table = new JTable(model);
		scrollPane.setViewportView(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder("仓库信息"));

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
		new AddWarehouseFrame();
		
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
				System.out.println("未选择删除的列！");
			}
			if (id == null){
				 JOptionPane.showMessageDialog(null, "请选取需要删除的供货商！", "警告", JOptionPane.ERROR_MESSAGE);
				return;
				}
			
			
			//询问用户是否真的删除该供货商
			int isdel = JOptionPane.showConfirmDialog(null,
				       "是否确定删除该仓库信息？", "删除仓库信息？", JOptionPane.YES_NO_OPTION,
				       JOptionPane.WARNING_MESSAGE, null);
			if(isdel == 1)
				return;
			
			textField.setText("");
			textField_1.setText("");
			
			dao.delWarehouse(id);
			table.setModel(new WarehouseTabelModel());
			
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
			String id = textField.getText();
			String principal = textField_1.getText();
			List<Warehouse> list = null;
			Warehouse warehouse = null;
			if (!id.equals("")){
					warehouse = dao.getWarehouseById(id);
				if (warehouse == null){
					JOptionPane.showMessageDialog(null, "未查询到该ID,请重试！", "警告", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					textField_1.setText("");
					return ;
				}
				list = new ArrayList<Warehouse>();
				list.add(warehouse);
				table.removeAll();
				model.setData(list);
				table.setModel(model);
			}else if(!principal.equals("")){
				list = dao.getWarehouseListByPrincipal(principal);
				if (list.isEmpty()){
					JOptionPane.showMessageDialog(null, "未查询到该关键字,请重试！", "警告", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					textField_1.setText("");
				return;	
				}
				model.setData(list);
				table.setModel(model);
			}else if (principal.equals("") && id.equals("")){
				list = dao.getWarehouseList();
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
				 JOptionPane.showMessageDialog(null, "请选取需要修改的仓库！", "警告", JOptionPane.ERROR_MESSAGE);
				return;
				
			}
			
			textField.setText("");
			textField_1.setText("");
			//获取选取的供货商的信息
			Warehouse warehouse = dao.getWarehouseById(id);
			//将信息传入修改页面
			new UpdateWarehouseFrame(warehouse);
			table.setModel(new WarehouseTabelModel());
			
		}
		
	}
}
