package com.superMarket.baseFile.duty.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.superMarket.baseFile.duty.bean.Duty;
import com.superMarket.baseFile.duty.dao.DutyDao;
import com.superMarket.baseFile.duty.dao.DutyDaoImpl;
import com.superMarket.baseFile.duty.model.DutyTableModel;

public class UpdateDutyFrame {
	public JFrame frame;
	private JLabel label_6;
	private JLabel label_7;
	private JTextField t_dutyName;
	private JTextField t_description;

	private DutyDao dao = new DutyDaoImpl();
	private Duty duty = new Duty();
	
	public UpdateDutyFrame(Duty duty) {
		this.duty = duty;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 600, 293);
		frame.setTitle("添加销售商");
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		label_6 = new JLabel("职务名称：");
		label_6.setBounds(57, 78, 85, 15);
		frame.getContentPane().add(label_6);

		label_7 = new JLabel("职务描述：");
		label_7.setBounds(342, 78, 85, 15);
		frame.getContentPane().add(label_7);

		t_dutyName = new JTextField();
		t_dutyName.setColumns(10);
		t_dutyName.setBounds(140, 75, 127, 21);
		frame.getContentPane().add(t_dutyName);

		t_description = new JTextField();
		t_description.setColumns(10);
		t_description.setBounds(421, 75, 127, 21);
		frame.getContentPane().add(t_description);

		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setBounds(278, 78, 16, 15);
		frame.getContentPane().add(label_12);

		JButton button_add = new JButton("修改");
		button_add.setBounds(174, 152, 93, 23);
		frame.getContentPane().add(button_add);
		button_add.addActionListener(new AddButtonListener());

		JButton button_esc = new JButton("退出");
		button_esc.setBounds(342, 152, 93, 23);
		frame.getContentPane().add(button_esc);
		button_esc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);

			}
		});
		
		//设置属性
		t_dutyName.setText(duty.getDutyName());
		t_description.setText(duty.getDescription());
	}

	public class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			 String dutyName = t_dutyName.getText();
			 String description = t_description.getText();
			 String id = duty.getId();
			 if (dutyName.equals("") ){
				 JOptionPane.showMessageDialog(null, "请将输入职务名！", "提示", JOptionPane.ERROR_MESSAGE);
				 return ;
			 }
			 Duty duty = new Duty(id, dutyName, description);
			 dao.updateDuty(duty);
			DutyPanel.table.removeAll();
			DutyPanel.table.setModel(new DutyTableModel());
			 frame.setVisible(false);
		}

	}
}
