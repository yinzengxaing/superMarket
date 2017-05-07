package com.superMarket.purchase.view;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.superMarket.baseFile.goods.dao.GoodsDao;
import com.superMarket.baseFile.goods.dao.GoodsDaoImpl;
import com.superMarket.purchase.bean.Purchase;
import com.superMarket.purchase.dao.PurchaseDao;
import com.superMarket.purchase.dao.PurchaseDaoImpl;
import com.superMarket.purchase.model.MyRender;
import com.superMarket.purchase.model.PurchaseTableModel;
import com.superMarket.utils.DateChooserJButton;

/**
 * 添加商品的窗口
 * 
 * @author administrator
 *
 */
public class AddPurchaseFrame {
	public JFrame frame;
	private JTextField t_sName;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_9;
	private JTextField t_goodsName;
	private JTextField t_count;
	private JTextField t_money;
	private  DateChooserJButton button;

	private PurchaseDao dao = new PurchaseDaoImpl();

	
	public AddPurchaseFrame() {
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

		JLabel label = new JLabel("客户名称：");
		label.setBounds(57, 36, 85, 15);
		frame.getContentPane().add(label);

		t_sName = new JTextField();
		t_sName.setBounds(140, 33, 127, 21);
		frame.getContentPane().add(t_sName);
		t_sName.setColumns(10);

		label_1 = new JLabel("交货日期：");
		label_1.setBounds(342, 36, 85, 15);
		frame.getContentPane().add(label_1);

		label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(278, 36, 16, 15);
		frame.getContentPane().add(label_2);

		label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setBounds(558, 36, 16, 15);
		frame.getContentPane().add(label_3);

		label_6 = new JLabel("商品名：");
		label_6.setBounds(57, 78, 85, 15);
		frame.getContentPane().add(label_6);

		label_7 = new JLabel("数量：");
		label_7.setBounds(342, 78, 85, 15);
		frame.getContentPane().add(label_7);

		label_9 = new JLabel("金额：");
		label_9.setBounds(57, 122, 85, 15);
		frame.getContentPane().add(label_9);

		t_goodsName = new JTextField();
		t_goodsName.setColumns(10);
		t_goodsName.setBounds(140, 75, 127, 21);
		frame.getContentPane().add(t_goodsName);

		t_count = new JTextField();
		t_count.setColumns(10);
		t_count.setBounds(421, 75, 127, 21);
		frame.getContentPane().add(t_count);

		t_money = new JTextField();
		t_money.setColumns(10);
		t_money.setBounds(140, 119, 127, 21);
		frame.getContentPane().add(t_money);

		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setBounds(278, 78, 16, 15);
		frame.getContentPane().add(label_12);

		JLabel label_14 = new JLabel("*");
		label_14.setForeground(Color.RED);
		label_14.setBounds(558, 78, 16, 15);
		frame.getContentPane().add(label_14);

		JButton button_add = new JButton("添加");
		button_add.setBounds(174, 176, 93, 23);
		frame.getContentPane().add(button_add);
		button_add.addActionListener(new AddButtonListener());

		JButton button_esc = new JButton("退出");
		button_esc.setBounds(342, 176, 93, 23);
		frame.getContentPane().add(button_esc);

		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setBounds(278, 122, 16, 15);
		frame.getContentPane().add(label_4);
		
		  button=new DateChooserJButton ();
		  button.setBounds(415, 32, 133, 23);
		frame.getContentPane().add(button);
		button_esc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);

			}
		});

	}

	public class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			String sName = t_sName.getText();
			String s = UUID.randomUUID().toString();
			s = s.substring(s.length()-5, s.length());
			  
			String orderId = s+button.getText().replace("-", "");
			String consignmentDate = button.getText();
			String goodsName = t_goodsName.getText();
			String strCount = t_count.getText();
			String Strmoney = t_money.getText();
			
			if (sName.equals("") ||goodsName.equals("") || strCount.equals("") || Strmoney.equals("") ){
				 JOptionPane.showMessageDialog(null, "请将信息补充完整！", "警告", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			
			//将字符转化为数字类型
			int count=0;
			double money =0.0;
			try {
				count = Integer.parseInt(strCount);
				money =Double.parseDouble(Strmoney);
			} catch (NumberFormatException e1) {
				t_count.setText("");
				t_money.setText("");
				 JOptionPane.showMessageDialog(null, "请输入合法数字！", "警告", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			
			Purchase purchase = new Purchase(null, sName, orderId, consignmentDate, goodsName, count, money, 0, -1);
			
			dao.addPurchase(purchase);
			PurchasePanel.table.removeAll();
			PurchasePanel.table.setModel(new PurchaseTableModel());
			PurchasePanel.table.getColumnModel().getColumn(0).setCellEditor(new MyRender());//设置编辑器
			PurchasePanel.table.getColumnModel().getColumn(0).setCellRenderer(new MyRender());
			 frame.setVisible(false);
			
			
		}

	}
}
