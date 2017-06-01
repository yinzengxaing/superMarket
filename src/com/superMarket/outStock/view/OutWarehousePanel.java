package com.superMarket.outStock.view;

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

import com.superMarket.outStock.bean.OutWarehouse;
import com.superMarket.outStock.dao.OutWarehouseDao;
import com.superMarket.outStock.dao.OutWarehouseDaoImpl;
import com.superMarket.outStock.model.OutWarehouseTableModel;

public class OutWarehousePanel {
	private JPanel myPanel;// 主界面
	private JTextField textField; // 订单号输入框
	private JTextField textField_1; // 入库时间输入框
	public static JTable table;
	private JPanel TablePanel;
	private OutWarehouseTableModel model;
	private OutWarehouseDao dao = new OutWarehouseDaoImpl();

	public JPanel getPanel() {

		myPanel = new JPanel();

		myPanel.setLayout(null);
		myPanel.setSize(888, 500);
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel.setBounds(2, 4, 1000, 46);
		myPanel.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("订单号：");
		label.setBounds(10, 21, 78, 15);
		panel.add(label);

		textField = new JTextField();
		textField.setBounds(70, 18, 86, 21);
		panel.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("出库时间:");
		label_1.setBounds(160, 21, 70, 15);
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

		TablePanel = new JPanel();
		TablePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TablePanel.setBounds(2, 60, 1000, 550);
		myPanel.add(TablePanel);

		TablePanel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		TablePanel.add(scrollPane);
		model = new OutWarehouseTableModel();
		table = new JTable(model);
		scrollPane.setViewportView(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder("出库列表"));
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
			new addOutWarehouseFrame();
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
				JOptionPane.showMessageDialog(null, "请选择需要删除的入库项！", "警告", JOptionPane.ERROR_MESSAGE);
				return;
			}

			int isdel = JOptionPane.showConfirmDialog(null, "是否确定删除该入库项？", "删除入库项？", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE, null);
			if (isdel == 1)
				return;
			textField.setText("");
			dao.delOutWarehouse(id);
			table.removeAll();
			table.setModel(new OutWarehouseTableModel());
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

			String derId = textField.getText();
			String inDate = textField_1.getText();
			List<OutWarehouse> list = null;
			list = dao.selectOutwarehouseList(derId, inDate);
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(null, "未查询到该关键字,请重试！", "警告", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				textField_1.setText("");
				return;
			}
			table.removeAll();
			model.setData(list);

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

			// 获取选取的行
			String id;
			int row = table.getSelectedRow(); // 获取选取的id
			try {

				id = (String) table.getValueAt(row, 0); // 获取选取的销售商
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "请选取需要修改的入库项！", "警告", JOptionPane.ERROR_MESSAGE);
				return;
			}

			OutWarehouse outWarehouseById = dao.getOutWarehouseById(id);
			textField.setText("");
			new updateOutWarehouseFrame(outWarehouseById);
			table.setModel(new OutWarehouseTableModel());
			//
		}

	}

}
