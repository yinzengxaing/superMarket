package com.superMarket.login.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.superMarket.login.MainFrame;
import com.superMarket.login.bean.User;
import com.superMarket.login.dao.UserDao;
import com.superMarket.login.dao.impl.UserDaoImpl;
import com.superMarket.utils.ImgPanel;

import javax.swing.UIManager;

public class Login {

	private UserDao userDao = new UserDaoImpl();
	private JFrame frame;
	private JTextField usernameField; //用户名框
	private JPasswordField passwordField; //密码框
	private JLabel label;
	private String username; //  获取的用户名
	private String password; //获取的密码
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					window.frame.setTitle("用户登录");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.ORANGE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(500, 200, 411, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//背景
		Panel panel_1 = new ImgPanel("./imgs/background.jpg");
		panel_1.setBounds(0, 0, 405, 150);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		//下边的背景
		Panel panel = new ImgPanel("");
		panel.setBounds(0, 148, 405, 155);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//用户名标签
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(298, 34, 49, 15);
		panel.add(lblNewLabel);
		
		//输入用户名框
		usernameField = new JTextField();
		usernameField.setBounds(130, 31, 158, 21);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		//用户密码表现
		passwordField = new JPasswordField();
		passwordField.setBounds(130, 62, 158, 21);
		panel.add(passwordField);
		
		//密码框
		label = new JLabel("密码");
		label.setForeground(Color.BLUE);
		label.setBounds(298, 65, 54, 15);
		panel.add(label);
		
		//登陆按钮
		JButton button = new JButton("登录");
		button.setBackground(Color.GREEN);
		//button.setIcon(new ImageIcon("./icon/plan.png"));
/*		button.setBorder(null);//去边框
		button.setContentAreaFilled(false);*/
	
		button.setBounds(140, 122, 191, 23);
		panel.add(button);
		//登陆按钮监听器
		button.addActionListener(new loginButrtenListener());
		
		JCheckBox checkBox = new JCheckBox("记住密码");
		checkBox.setForeground(Color.BLUE);
		checkBox.setBounds(130, 89, 81, 23);
		panel.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("自动登录");
		checkBox_1.setForeground(Color.BLUE);
		checkBox_1.setBounds(248, 89, 81, 23);
		panel.add(checkBox_1);
		
		Panel panel_2 = new ImgPanel("./imgs/login_me.jpg");
		panel_2.setBounds(10, 20, 100, 100);
		panel.add(panel_2);
		
		
	}
	
	/**
	 * 登陆按钮监听器
	 * @author user
	 *
	 */
	public class loginButrtenListener  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("nihao");
			//获取用户名
			username = usernameField.getText();
			//获取密码
			 char[] passwordChar = passwordField.getPassword();
			 password = String.valueOf(passwordChar);
			 
		
				 User user = new User(username, password);
				 User finduser = userDao.getUserByUsernameAndPassword(user);
				 
				 if (finduser != null){
				 frame.setVisible(false);
				 System.out.println("登陆成功");
				 MainFrame mainFrame = new MainFrame();
				 mainFrame.main(null);
			 }else {
				 JOptionPane.showMessageDialog(null, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
				 passwordField.setText("");
				 usernameField.setText("");
			}
			
		}
		
	}
}
