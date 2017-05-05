package com.superMarket.baseFile.duty.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import com.superMarket.baseFile.duty.bean.Duty;
import com.superMarket.baseFile.duty.dao.DutyDao;
import com.superMarket.baseFile.duty.dao.DutyDaoImpl;
import com.superMarket.baseFile.duty.model.DutyTableModel;
import com.superMarket.baseFile.goods.view.AddGoodsFrame;

public class DutyPanel {
	private JPanel myPanel;// 主界面
	private JTextField textField; // 货品名称输入框
	//private JTextField textField_1; // 地址输入框
	public static JTable table;
	private JPanel TablePanel;
	private DutyTableModel model;
	private DutyDao dao = new DutyDaoImpl();

	public JPanel getDutyPanel() {

		myPanel = new JPanel();

		myPanel.setLayout(null);
		myPanel.setSize(888, 500);
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		panel.setBounds(2, 4, 1000, 46);
		myPanel.add(panel);
		panel.setLayout(null);

		/*JLabel label = new JLabel("职务名称：");
		label.setBounds(10, 21, 78, 15);
		panel.add(label);

		textField = new JTextField();
		textField.setBounds(91, 18, 130, 21);
		panel.add(textField);
		textField.setColumns(10);*/

/*		JButton button_search = new JButton("搜索");
		button_search.setBounds(343, 17, 67, 23);
		panel.add(button_search);
		button_search.addActionListener(new SearchButtonListener());*/

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
		model = new DutyTableModel();
		table = new JTable(model);
		scrollPane.setViewportView(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder("职务列表"));

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
		new AddDutyFrame();
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
				 JOptionPane.showMessageDialog(null, "请选择需要删除的职务！", "警告", JOptionPane.ERROR_MESSAGE);
			return ;
			}
			
			int isdel = JOptionPane.showConfirmDialog(null, "是否确定删除该职务？", "删除职务？", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE, null);
			if (isdel == 1)
				return;
			
			dao.delDuty(id);
			// table.removeAll();
			table.setModel(new DutyTableModel());
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
			String id = null;
			 int row = table.getSelectedRow(); //获取选取的id 
			 try {
					
				 id =  (String) table.getValueAt(row, 0); //获取选取的职务
			} catch (Exception e2) {
				 JOptionPane.showMessageDialog(null, "请选取需要修改职务！", "警告", JOptionPane.ERROR_MESSAGE);
					return;
			}
			 
			 Duty duty = dao.getDutyById(id);
			new UpdateDutyFrame(duty);
			 
			  table.setModel(new DutyTableModel());
			 
		}

	}

}
