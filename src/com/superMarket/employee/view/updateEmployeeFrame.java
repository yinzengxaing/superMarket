package com.superMarket.employee.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.superMarket.baseFile.duty.bean.Duty;
import com.superMarket.baseFile.duty.dao.DutyDao;
import com.superMarket.baseFile.duty.dao.DutyDaoImpl;
import com.superMarket.department.bean.Department;
import com.superMarket.department.dao.DepartmentDao;
import com.superMarket.department.dao.DepartmentDaoImpl;
import com.superMarket.employee.bean.Employee;
import com.superMarket.employee.dao.EmployeeDao;
import com.superMarket.employee.dao.EmployeeDaoImpl;
import com.superMarket.employee.model.EmployeeTableModel;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class updateEmployeeFrame {

	private JFrame frame;
	private JTextField t_name;
	private JTextField t_age;
	private ButtonGroup bg;// 创建按钮组
	private JTextField t_phone;
	private JTextField t_officePhone;
	private JTextField t_fox;
	private JTextField t_email;
	private JTextField t_address;
	private JTextField textField_1;
	private JComboBox comboBox_duty;
	private JComboBox comboBox_department;
	private JRadioButton nanBtn;
	private JRadioButton nvBtn;
	
	private Employee employee ;
	private DutyDao dutyDao = new DutyDaoImpl();
	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	private String duty;
	private String department;
	private JLabel lblNewLabel_1;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;

	public updateEmployeeFrame(Employee employee) {
		this.employee = employee;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 620, 437);
		frame.getContentPane().setLayout(null);
		
		JButton addButton = new JButton("保存");
		addButton.setBounds(162, 307, 93, 23);
		frame.getContentPane().add(addButton);
		addButton.addActionListener(new addBtnListener());
		JButton escBtn = new JButton("退出");
		escBtn.setBounds(319, 307, 93, 23);
		frame.getContentPane().add(escBtn);
		
		JLabel label = new JLabel("姓名：");
		label.setBounds(41, 25, 54, 15);
		frame.getContentPane().add(label);
		
		t_name = new JTextField();
		t_name.setBounds(89, 22, 127, 21);
		frame.getContentPane().add(t_name);
		t_name.setColumns(10);
		
		JLabel label_1 = new JLabel("年龄：");
		label_1.setBounds(319, 25, 54, 15);
		frame.getContentPane().add(label_1);
		
		t_age = new JTextField();
		t_age.setColumns(10);
		t_age.setBounds(361, 22, 150, 21);
		frame.getContentPane().add(t_age);
		
		 nanBtn = new JRadioButton("男");
		 nanBtn.setSelected(true);
		nanBtn.setBounds(89, 69, 43, 23);
		frame.getContentPane().add(nanBtn);
		
		nvBtn = new JRadioButton("女");
		nvBtn.setBounds(145, 69, 54, 23);
		frame.getContentPane().add(nvBtn);
		bg = new ButtonGroup();
		bg.add(nanBtn);
		bg.add(nvBtn);
		
		
		JLabel label_2 = new JLabel("性别：");
		label_2.setBounds(41, 73, 54, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("部门：");
		label_3.setBounds(319, 73, 54, 15);
		frame.getContentPane().add(label_3);
		
		comboBox_department = new JComboBox();
		comboBox_department.setBounds(367, 70, 145, 21);
		//获取数据
		List<Department> departmentList = departmentDao.getDepartmentList();
		for (Department department : departmentList) {
			comboBox_department.addItem(department.getDepName());
		}
		frame.getContentPane().add(comboBox_department);
		
		JLabel label_4 = new JLabel("职务：");
		label_4.setBounds(41, 125, 54, 15);
		frame.getContentPane().add(label_4);
		
		comboBox_duty = new JComboBox();
		comboBox_duty.setBounds(110, 122, 145, 21);
		//获取数据
		List<Duty> dutyList = dutyDao.getDutyList();
		for (Duty duty : dutyList) {
			comboBox_duty.addItem(duty.getDutyName());
		}
		frame.getContentPane().add(comboBox_duty);
		
		t_phone = new JTextField();
		t_phone.setBounds(373, 122, 150, 21);
		frame.getContentPane().add(t_phone);
		t_phone.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("手机：");
		lblNewLabel.setBounds(319, 128, 43, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_5 = new JLabel("办公电话：");
		label_5.setBounds(41, 168, 73, 15);
		frame.getContentPane().add(label_5);
		
		t_officePhone = new JTextField();
		t_officePhone.setBounds(105, 165, 129, 21);
		frame.getContentPane().add(t_officePhone);
		t_officePhone.setColumns(10);
		
		JLabel label_6 = new JLabel("传真：");
		label_6.setBounds(319, 171, 73, 15);
		frame.getContentPane().add(label_6);
		
		t_fox = new JTextField();
		t_fox.setColumns(10);
		t_fox.setBounds(367, 165, 144, 21);
		frame.getContentPane().add(t_fox);
		
		JLabel label_7 = new JLabel("邮箱：");
		label_7.setBounds(41, 216, 73, 15);
		frame.getContentPane().add(label_7);
		
		t_email = new JTextField();
		t_email.setColumns(10);
		t_email.setBounds(101, 213, 129, 21);
		frame.getContentPane().add(t_email);
		
		JLabel labelss = new JLabel("居住地址：");
		labelss.setBounds(306, 216, 67, 15);
		frame.getContentPane().add(labelss);
		
		t_address = new JTextField();
		t_address.setColumns(10);
		t_address.setBounds(384, 213, 127, 21);
		frame.getContentPane().add(t_address);
		
		textField_1 = new JTextField();
		textField_1.setBounds(394, 213, -2, 41);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(226, 28, 32, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setBounds(527, 25, 32, 15);
		frame.getContentPane().add(label_8);
		
		label_9 = new JLabel("*");
		label_9.setForeground(Color.RED);
		label_9.setBounds(527, 125, 32, 15);
		frame.getContentPane().add(label_9);
		
		label_10 = new JLabel("*");
		label_10.setForeground(Color.RED);
		label_10.setBounds(527, 216, 32, 15);
		frame.getContentPane().add(label_10);
		
		label_11 = new JLabel("*");
		label_11.setForeground(Color.RED);
		label_11.setBounds(251, 216, 32, 15);
		frame.getContentPane().add(label_11);
		
		label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setBounds(226, 73, 32, 15);
		frame.getContentPane().add(label_12);
		
		label_13 = new JLabel("*");
		label_13.setForeground(Color.RED);
		label_13.setBounds(265, 125, 32, 15);
		frame.getContentPane().add(label_13);
		
		label_14 = new JLabel("*");
		label_14.setForeground(Color.RED);
		label_14.setBounds(527, 73, 32, 15);
		frame.getContentPane().add(label_14);
		
		label_15 = new JLabel("*");
		label_15.setForeground(Color.RED);
		label_15.setBounds(238, 168, 32, 15);
		frame.getContentPane().add(label_15);
		
		label_16 = new JLabel("*");
		label_16.setForeground(Color.RED);
		label_16.setBounds(527, 168, 32, 15);
		frame.getContentPane().add(label_16);
		escBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		//回显数据
		t_address.setText(employee.getAddress());
		t_age.setText(employee.getAge()+"");
		t_email.setText(employee.getEmail());
		t_fox.setText(employee.getFax());
		t_name.setText(employee.getName());
		t_officePhone.setText(employee.getOfficePhone());
		t_phone.setText(employee.getPhone());
		comboBox_department.setSelectedItem(employee.getDepartment());
		comboBox_duty.setSelectedItem(employee.getDuty());
		
		String sex = employee.getSex();
		if (sex.equals("男"))
			nanBtn.setSelected(true);
		if(sex.equals("女"))
			nvBtn.setSelected(true);
	}
	
class addBtnListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String address = t_address.getText();
		String ageStr = t_age.getText();
		String email = t_email.getText();
		String fax = t_fox.getText();
		String name = t_name.getText();
		String officePhone = t_officePhone.getText();
		String phone = t_phone.getText();
		String duty = comboBox_duty.getSelectedItem().toString();
		String department = comboBox_department.getSelectedItem().toString();
		String sex  = null ;
		if (nanBtn.isSelected())
			sex = "男";
		else if (nvBtn.isSelected())
			sex = "女";
		if (address.equals("") || ageStr.equals("") || email.equals("") || fax.equals("") || name.equals("") || officePhone.equals("") || phone.equals("")){
			JOptionPane.showMessageDialog(null, "请将信息补充完整！", "警告", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		int age = 0;
		try {
			age = Integer.parseInt(ageStr);
		} catch (NumberFormatException e) {
			t_age.setText("");
			JOptionPane.showMessageDialog(null, "请将输入合法数字！", "警告", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Employee newemployee = new Employee( employee.getId(), name, age, sex, duty, department, phone, officePhone, fax, email, address);
		employeeDao.updateEmployee(newemployee);
		EmployeePanel.table.removeAll();
		EmployeePanel.table.setModel(new EmployeeTableModel());
		frame.setVisible(false);
	}
	
}
}
