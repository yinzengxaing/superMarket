package com.superMarket.purchase.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import com.superMarket.purchase.bean.Purchase;
import com.superMarket.purchase.dao.PurchaseDao;
import com.superMarket.purchase.dao.PurchaseDaoImpl;
import com.superMarket.purchase.model.MyRender;
import com.superMarket.purchase.model.PurchaseTableModel;

public class PurchasePanel {

	
	private JPanel myPanel;//主界面
	private JComboBox<String> itemsBox;
	private JTextField textField_1; //地址输入框
	public  static JTable table;
	public static JPanel tablePanel;
	private  PurchaseTableModel  model; 
	private PurchaseDao purchaseDao = new PurchaseDaoImpl();
	private String SelectItem;
	public JPanel getPurchasePanel(){

		myPanel = new JPanel();
		
		myPanel.setLayout(null);
		myPanel.setSize(888, 500);
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel.setBounds(2, 4, 1000, 46);
		myPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("查询条件：");
		label.setBounds(10, 21, 78, 15);
		panel.add(label);
		
		itemsBox  = new JComboBox<String>();
		itemsBox.addItem("请选择...");
		itemsBox.addItem("客户名");
		itemsBox.addItem("商品名");
		itemsBox.setBounds(91, 18, 86, 21);
		panel.add(itemsBox);
		itemsBox.addItemListener(new ItemsListener());
/*		
		
		JLabel label_1 = new JLabel("地址：");
		label_1.setBounds(187, 21, 54, 15);
		panel.add(label_1);*/
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 18, 130, 21);
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
		model= new PurchaseTableModel();
		table = new JTable(model);

        //添加渲染器
		table.getColumnModel().getColumn(0).setCellEditor(new MyRender());//设置编辑器
		table.getColumnModel().getColumn(0).setCellRenderer(new MyRender());
		
		scrollPane.setViewportView(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder("订单信息"));

		return myPanel;
		
	}
	
	/**
	 * 选择项监听器
	 * @author administrator
	 *
	 */
	public class  ItemsListener  implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED){
				String item = (String)itemsBox.getSelectedItem();
				SelectItem = item;
			}
		}
		
	}
	
	/**
	 * 添加按钮监听器
	 * @author administrator
	 *
	 */
	public class AddButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new AddPurchaseFrame();
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
			 id  = (String) table.getValueAt(row, 1);
			}catch (ArrayIndexOutOfBoundsException ex){
				System.out.println("未选择修改的列！");
			}
			if (id == null){
				 JOptionPane.showMessageDialog(null, "请选取需要删除订单信息", "警告", JOptionPane.ERROR_MESSAGE);
				return;
				}
			
			
			//询问用户是否真的删除该供货商
			int isdel = JOptionPane.showConfirmDialog(null,
				       "是否确定删除该订单信息？", "删除订单信息？", JOptionPane.YES_NO_OPTION,
				       JOptionPane.WARNING_MESSAGE, null);
			if(isdel == 1)
				return;
			
			textField_1.setText("");
			
			
			
			purchaseDao.delPurchase(id);
			//table.removeAll();
			table.removeAll();
			table.setModel(new PurchaseTableModel());
			table.getColumnModel().getColumn(0).setCellEditor(new MyRender());//设置编辑器
			table.getColumnModel().getColumn(0).setCellRenderer(new MyRender());
			
			
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
			
			
			List<Purchase> list = null;
			String SelectStr = textField_1.getText();
			System.out.println(SelectItem);
			if (SelectItem== null || SelectItem.equals("请选择...")){
				JOptionPane.showMessageDialog(null, "请选择查询条件", "警告", JOptionPane.ERROR_MESSAGE);
				textField_1.setText("");
				return;
			}else if (SelectItem.equals("客户名")){
				 list = purchaseDao.getPurchaseListBySName(SelectStr);
				 if (list.isEmpty()){
						JOptionPane.showMessageDialog(null, "未查询到该关键字,请重试！", "警告", JOptionPane.ERROR_MESSAGE);
						textField_1.setText("");
					return;	
					}
					table.removeAll();
					table.setModel(new PurchaseTableModel(list));
					table.getColumnModel().getColumn(0).setCellEditor(new MyRender());//设置编辑器
					table.getColumnModel().getColumn(0).setCellRenderer(new MyRender());
				 
			}else if (SelectItem.equals("商品名")){
				 list = purchaseDao.getPurchaseListByGoodsName(SelectStr);
				 if (list.isEmpty()){
						JOptionPane.showMessageDialog(null, "未查询到该关键字,请重试！", "警告", JOptionPane.ERROR_MESSAGE);
						textField_1.setText("");
					return;	
					}
					table.removeAll();
					table.setModel(new PurchaseTableModel(list));
					table.getColumnModel().getColumn(0).setCellEditor(new MyRender());//设置编辑器
					table.getColumnModel().getColumn(0).setCellRenderer(new MyRender());
				 
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
			id = (String) table.getValueAt(row, 1);
			}catch(ArrayIndexOutOfBoundsException ex){
				System.out.println("未选取修改的行");
			}
			
			if (id == null){
				 JOptionPane.showMessageDialog(null, "请选取需要修改的供货商！", "警告", JOptionPane.ERROR_MESSAGE);
				return;
				
			}
			textField_1.setText("");
			//获取选取的供货商的信息
			Purchase purchase = purchaseDao.getPurchaseById(id);
			//将信息传入修改页面
			new UpdatePurchaseFrame(purchase);
			table.removeAll();
			table.setModel(new PurchaseTableModel());
			table.getColumnModel().getColumn(0).setCellEditor(new MyRender());//设置编辑器
			table.getColumnModel().getColumn(0).setCellRenderer(new MyRender());
			
		}
		
	}
}