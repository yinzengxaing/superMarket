package com.superMarket.department.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.superMarket.department.bean.Department;
import com.superMarket.department.dao.DepartmentDao;
import com.superMarket.department.dao.DepartmentDaoImpl;
import com.superMarket.department.model.DepartmentTabelModel;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateDepartmentFrame {

	private JFrame frame;
	private JTextField depName_t;
	private JTextField principal_t;
	private JTextArea describe_t;
	private Department department;
	private DepartmentDao dao = new DepartmentDaoImpl();

	public updateDepartmentFrame(Department department) {
		this.department = department;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 620, 437);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("部门名称：");
		label.setBounds(46, 66, 70, 15);
		frame.getContentPane().add(label);
		
		depName_t = new JTextField();
		depName_t.setBounds(108, 63, 147, 21);
		frame.getContentPane().add(depName_t);
		depName_t.setColumns(10);
		
		JLabel label_1 = new JLabel("负责人：");
		label_1.setBounds(319, 66, 60, 15);
		frame.getContentPane().add(label_1);
		
		principal_t = new JTextField();
		principal_t.setColumns(10);
		principal_t.setBounds(383, 63, 147, 21);
		frame.getContentPane().add(principal_t);
		
		JLabel label_2 = new JLabel("描述：");
		label_2.setBounds(46, 150, 54, 15);
		frame.getContentPane().add(label_2);
		
		describe_t = new JTextArea();
		describe_t.setBounds(108, 146, 332, 118);
		frame.getContentPane().add(describe_t);
		
		JButton addButton = new JButton("添加");
		addButton.setBounds(162, 307, 93, 23);
		frame.getContentPane().add(addButton);
		addButton.addActionListener(new addBtnListener());
		JButton escBtn = new JButton("退出");
		escBtn.setBounds(319, 307, 93, 23);
		frame.getContentPane().add(escBtn);
		escBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setBounds(265, 66, 16, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setBounds(540, 66, 16, 15);
		frame.getContentPane().add(label_4);
		
		//设置数据
		depName_t.setText(department.getDepName());
		principal_t.setText(department.getPrincipal());
		describe_t.setText(department.getDescription());
	}
	
class addBtnListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String depName = depName_t.getText();
		String principal = principal_t.getText();
		String description =  describe_t.getText();
		if (depName.equals("") || principal.equals("")){
			JOptionPane.showMessageDialog(null, "请将信息补充完整！", "警告", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Department newdepartment = new Department(department.getId(), depName, principal, description);
		dao.updateDepartment(newdepartment);
		DepartmentPanel.table.removeAll();
		DepartmentPanel.table.setModel(new DepartmentTabelModel());
		frame.setVisible(false);
	}
	
}
}
