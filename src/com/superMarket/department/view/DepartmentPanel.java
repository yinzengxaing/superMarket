package com.superMarket.department.view;

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

import com.superMarket.department.bean.Department;
import com.superMarket.department.dao.DepartmentDao;
import com.superMarket.department.dao.DepartmentDaoImpl;
import com.superMarket.department.model.DepartmentTabelModel;
import com.superMarket.purchase.bean.Purchase;
import com.superMarket.purchase.dao.PurchaseDao;
import com.superMarket.purchase.dao.PurchaseDaoImpl;
import com.superMarket.purchase.model.MyRender;
import com.superMarket.purchase.model.PurchaseTableModel;

public class DepartmentPanel {

	
	private JPanel myPanel;//主界面
	private JComboBox<String> itemsBox; //存放查询条件
	private JTextField textField_1; //输入框
	public  static JTable table;
	public static JPanel tablePanel;
	private  DepartmentTabelModel  model; 
	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	private String SelectItem;
	public JPanel getPanel(){

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
		itemsBox.addItem("部门名称");
		itemsBox.addItem("负责人");
		itemsBox.setBounds(91, 18, 86, 21);
		panel.add(itemsBox);
		itemsBox.addItemListener(new ItemsListener());
		
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
		model= new DepartmentTabelModel();
		table = new JTable(model);

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
			new addDepartmentFrame();
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
				 JOptionPane.showMessageDialog(null, "请选取需要删除订单信息", "警告", JOptionPane.ERROR_MESSAGE);
					return;
			}
			//询问用户是否真的删除该供货商
			int isdel = JOptionPane.showConfirmDialog(null,
				       "是否确定删除该部门信息？", "删除部门信息？", JOptionPane.YES_NO_OPTION,
				       JOptionPane.WARNING_MESSAGE, null);
			if(isdel == 1)
				return;
			departmentDao.deleteDepartment(id);
			textField_1.setText("");
			table.removeAll();
			table.setModel(new DepartmentTabelModel());
			
			
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
			
			
			List<Department> list = null;
			String SelectStr = textField_1.getText();
			if (SelectItem== null || SelectItem.equals("请选择...")){
				JOptionPane.showMessageDialog(null, "请选择查询条件", "警告", JOptionPane.ERROR_MESSAGE);
				textField_1.setText("");
				return;
			}else if (SelectItem.equals("部门名称")){
				 list = departmentDao.selectByDepname(SelectStr);
				 if (list.isEmpty()){
						JOptionPane.showMessageDialog(null, "未查询到该关键字,请重试！", "警告", JOptionPane.ERROR_MESSAGE);
						textField_1.setText("");
					return;	
					}
				 model.setData(list);
				 
			}else if (SelectItem.equals("负责人")){
				 list = departmentDao.selectByPrincipal(SelectStr);
				 if (list.isEmpty()){
						JOptionPane.showMessageDialog(null, "未查询到该关键字,请重试！", "警告", JOptionPane.ERROR_MESSAGE);
						textField_1.setText("");
					return;	
					}
				 	model.setData(list);
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
				 JOptionPane.showMessageDialog(null, "请选取需要修改的供货商！", "警告", JOptionPane.ERROR_MESSAGE);
				return;
			}
			textField_1.setText("");
			Department departmentById = departmentDao.getDepartmentById(id);
			new updateDepartmentFrame(departmentById);
			
		}
		
	}
}