package com.superMarket.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import com.superMarket.baseFile.BaseFilePanel;
import com.superMarket.inStock.BaseInWarehousePanel;
import com.superMarket.outStock.BaseOutWarehousePanel;
import com.superMarket.purchase.BasePurchasePanel;
import com.superMarket.purchase.bean.Purchase;
import com.superMarket.utils.ImgPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class MainFrame {

	private JFrame frame;
	private JPanel backPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 50, 1193, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(true);
		menuBar.setBounds(0, 0, 1175, 21);
		frame.getContentPane().add(menuBar);

		JMenu menu = new JMenu("文件");
		menuBar.add(menu);

		JMenu menu_1 = new JMenu("帮助");
		menuBar.add(menu_1);

		JMenuItem menuItem = new JMenuItem("关于");
		menu_1.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("使用说明");
		menu_1.add(menuItem_1);

		JMenu menu_2 = new JMenu("退出");
		menuBar.add(menu_2);

		JPanel panel = new JPanel();
		panel.setBounds(0, 20, 1175, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// 订单采购按钮
		JButton button = new JButton();
		button.setIcon(new ImageIcon("./icon/plan.png"));
		button.setBorder(null);// 去边框
		button.setContentAreaFilled(false);
		button.setBounds(185, 0, 104, 44);
		panel.add(button);
		button.addActionListener(new OrderButtenListener());

		// 入库管理按钮
		JButton button_1 = new JButton();
		button_1.setBorder(null);// 去边框
		button_1.setContentAreaFilled(false);
		button_1.setIcon(new ImageIcon("./icon/in.png"));
		button_1.setBounds(386, 0, 104, 44);
		panel.add(button_1);
		button_1.addActionListener(new InStack());

		// 出库管理按钮
		JButton button_2 = new JButton();
		button_2.setBorder(null);// 去边框
		button_2.setContentAreaFilled(false);
		button_2.setIcon(new ImageIcon("./icon/out.png"));
		button_2.setBounds(572, 0, 104, 44);
		panel.add(button_2);
		button_2.addActionListener(new OutStack());

		// 人员管理按钮
		JButton button_3 = new JButton("");
		button_3.setBorder(null);// 去边框
		button_3.setContentAreaFilled(false);
		button_3.setIcon(new ImageIcon("./icon/people.png"));
		button_3.setBounds(782, 0, 104, 44);
		panel.add(button_3);

		// 部门管理按钮
		JButton button_4 = new JButton("");
		button_4.setBorder(null);// 去边框
		button_4.setContentAreaFilled(false);
		button_4.setIcon(new ImageIcon("./icon/employee.png"));
		button_4.setBounds(992, 0, 104, 44);
		panel.add(button_4);

		// 基本档案管理
		JButton btnNewButton = new JButton(/* "基本档案" */);
		btnNewButton.setBorder(null);// 去边框
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon("./icon/file.png"));
		btnNewButton.setBounds(0, 0, 104, 44);
		panel.add(btnNewButton);
		// 添加事件监听
		btnNewButton.addActionListener(new FileButtenListener());

		JLabel label = new JLabel("基本档案");
		label.setForeground(Color.BLUE);
		label.setBounds(24, 46, 54, 15);
		panel.add(label);

		JLabel label_1 = new JLabel("订单采购");
		label_1.setForeground(Color.BLUE);
		label_1.setBounds(215, 46, 54, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("入库管理");
		label_2.setForeground(Color.BLUE);
		label_2.setBounds(412, 46, 54, 15);
		panel.add(label_2);

		JLabel label_3 = new JLabel("出库管理");
		label_3.setForeground(Color.BLUE);
		label_3.setBounds(596, 46, 54, 15);
		panel.add(label_3);

		JLabel label_4 = new JLabel("人员管理");
		label_4.setForeground(Color.BLUE);
		label_4.setBounds(807, 46, 54, 15);
		panel.add(label_4);

		JLabel label_5 = new JLabel("部门管理");
		label_5.setForeground(Color.BLUE);
		label_5.setBounds(1017, 46, 54, 15);
		panel.add(label_5);

		backPanel = new JPanel();
		backPanel.setBounds(0, 91, 1175, 637);
		backPanel.setVisible(true);
		frame.getContentPane().add(backPanel);
		backPanel.setLayout(new BorderLayout(0, 0));

		 Panel background = new ImgPanel("./imgs/fengjing.jpg");
		 backPanel.add(background);
		 background.setLayout(new BorderLayout(0, 0));
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	/**
	 * 基本档案按钮点击事件
	 * 
	 * @author 惠普
	 *
	 */
	public class FileButtenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			backPanel.removeAll();
			BaseFilePanel panel = new BaseFilePanel();
			backPanel.add(panel);
			backPanel.validate();
			backPanel.repaint();
		}

	}

	/**
	 * 采购计划按钮点击事件
	 * 
	 * @author 惠普
	 *
	 */

	public class OrderButtenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			backPanel.removeAll();
			BasePurchasePanel basePurchasePanel = new BasePurchasePanel();
			backPanel.add(basePurchasePanel);
			backPanel.validate();
			backPanel.repaint();
		}

	}

	/**
	 * 入库管理按钮点击事件
	 * 
	 * @author 惠普
	 *
	 */

	public class InStack implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			backPanel.removeAll();
			BaseInWarehousePanel inWarehousePanel = new BaseInWarehousePanel();
			backPanel.add(inWarehousePanel);
			backPanel.validate();
			backPanel.repaint();

		}

	}

	/**
	 * 出库管理按钮点击事件
	 * 
	 * @author 惠普
	 *
	 */

	public class OutStack implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			backPanel.removeAll();
			BaseOutWarehousePanel outWarehousePanel = new BaseOutWarehousePanel();
			backPanel.add(outWarehousePanel);
			backPanel.validate();
			backPanel.repaint();
		}
	}

	/**
	 * 人员管理按钮点击事件
	 * 
	 * @author 惠普
	 *
	 */

	public class ManagePeope implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * 部门管理按钮点击事件
	 * 
	 * @author 惠普
	 *
	 */

	public class ManageDepartment implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}
}
