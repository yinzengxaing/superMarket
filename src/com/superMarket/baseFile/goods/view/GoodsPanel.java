package com.superMarket.baseFile.goods.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import com.superMarket.baseFile.goods.bean.Goods;
import com.superMarket.baseFile.goods.dao.GoodsDao;
import com.superMarket.baseFile.goods.dao.GoodsDaoImpl;
import com.superMarket.baseFile.goods.model.GoodsTableModel;

public class GoodsPanel {
	private JPanel myPanel;// 主界面
	private JTextField textField; // 货品名称输入框
	//private JTextField textField_1; // 地址输入框
	public static JTable table;
	private JPanel TablePanel;
	private GoodsTableModel model;
	private GoodsDao dao = new GoodsDaoImpl();

	public JPanel getGoodsPanel() {

		myPanel = new JPanel();

		myPanel.setLayout(null);
		myPanel.setSize(888, 500);
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel.setBounds(2, 4, 1000, 46);
		myPanel.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("货品名称：");
		label.setBounds(10, 21, 78, 15);
		panel.add(label);

		textField = new JTextField();
		textField.setBounds(91, 18, 130, 21);
		panel.add(textField);
		textField.setColumns(10);

/*		JLabel label_1 = new JLabel("地址：");
		label_1.setBounds(187, 21, 54, 15);
		panel.add(label_1);*/

	/*	textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(223, 18, 86, 21);
		panel.add(textField_1);*/

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

		TablePanel = new JPanel();
		TablePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TablePanel.setBounds(2, 60, 1000, 550);
		myPanel.add(TablePanel);

		TablePanel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		TablePanel.add(scrollPane);
		model = new GoodsTableModel();
		table = new JTable(model);
		scrollPane.setViewportView(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder("货品列表"));

		return myPanel;

	}

	/**
	 * 添加按钮监听器
	 * 
	 * @author administrator
	 *
	 */
	public class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			textField.setText("");
			new AddGoodsFrame();
		}

	}

	/**
	 * 删除按钮监听器
	 * 
	 * @author administrator
	 *
	 */

	public class DeleteButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int row = table.getSelectedRow();
			String id = null;
			try {
				id = (String) table.getValueAt(row, 0);
			} catch (Exception e2) {
				 JOptionPane.showMessageDialog(null, "请选择需要删除的商品！", "警告", JOptionPane.ERROR_MESSAGE);
			return ;
			}
			
			int isdel = JOptionPane.showConfirmDialog(null, "是否确定删除该商品？", "删除商品？", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE, null);
			if (isdel == 1)
				return;
			textField.setText("");
			
			dao.delGoods(id);
			// table.removeAll();
			table.setModel(new GoodsTableModel());
		}

	}

	/**
	 * 搜索按钮监听器
	 * 
	 * @author administrator
	 *
	 */
	public class SearchButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = textField.getText();
			List<Goods> list = null;
			if (!name.equals("")) {
				list = dao.getGoodsListByName(name);
				if (list.isEmpty()){
					JOptionPane.showMessageDialog(null, "未查询到该关键字,请重试！", "警告", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
				return;	
				}
				table.removeAll();
				model.setData(list);
				table.setModel(model);
			} else if (name.equals("")) {
				list = dao.getGoodsList();
				model.setData(list);
				table.setModel(model);
			}
		}

	}

	/**
	 * 更新按钮的监听器
	 * 
	 * @author administrator
	 *
	 */
	public class UpdateButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			 //获取选取的行 
			String id;
			 int row = table.getSelectedRow(); //获取选取的id 
			 try {
					
				 id =  (String) table.getValueAt(row, 0); //获取选取的销售商
			} catch (Exception e2) {
				 JOptionPane.showMessageDialog(null, "请选取需要修改的商品！", "警告", JOptionPane.ERROR_MESSAGE);
					return;
			}
			 
			 Goods goods = dao.getGoodById(id);
			 textField.setText("");
			  new UpdateGoodsFrame(goods);
			  table.setModel(new GoodsTableModel());
			 
		}

	}

}
