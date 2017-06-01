package com.superMarket.baseFile.goods.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.superMarket.baseFile.goods.bean.Goods;
import com.superMarket.baseFile.goods.dao.GoodsDao;
import com.superMarket.baseFile.goods.dao.GoodsDaoImpl;
import com.superMarket.baseFile.goods.model.GoodsTableModel;
import com.superMarket.baseFile.seller.bean.Seller;
import com.superMarket.baseFile.seller.dao.SellerDao;
import com.superMarket.baseFile.seller.dao.SellerDaoImpl;
import com.superMarket.baseFile.seller.model.SellerTableModel;
import com.superMarket.baseFile.seller.view.SellerPanel;

/**
 * 添加商品的窗口
 * 
 * @author administrator
 *
 */
public class AddGoodsFrame {
	public JFrame frame;
	private JTextField t_goodsName;
	private JLabel label_1;
	private JTextField t_goodsBewrite;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JTextField t_units;
	private JTextField t_stockPrice;
	private JTextField t_associatorPrice;
	private JTextField t_retailPrice;

	private GoodsDao dao = new GoodsDaoImpl();

	public AddGoodsFrame() {
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

		JLabel label = new JLabel("货品名称：");
		label.setBounds(57, 36, 85, 15);
		frame.getContentPane().add(label);

		t_goodsName = new JTextField();
		t_goodsName.setBounds(140, 33, 127, 21);
		frame.getContentPane().add(t_goodsName);
		t_goodsName.setColumns(10);

		label_1 = new JLabel("货品描述：");
		label_1.setBounds(342, 36, 85, 15);
		frame.getContentPane().add(label_1);

		t_goodsBewrite = new JTextField();
		t_goodsBewrite.setColumns(10);
		t_goodsBewrite.setBounds(421, 33, 127, 21);
		frame.getContentPane().add(t_goodsBewrite);

		label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(278, 36, 16, 15);
		frame.getContentPane().add(label_2);

		label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setBounds(558, 36, 16, 15);
		frame.getContentPane().add(label_3);

		label_6 = new JLabel("单位：");
		label_6.setBounds(57, 78, 85, 15);
		frame.getContentPane().add(label_6);

		label_7 = new JLabel("进货价：");
		label_7.setBounds(342, 78, 85, 15);
		frame.getContentPane().add(label_7);

		label_8 = new JLabel("会员价：");
		label_8.setBounds(342, 122, 85, 15);
		frame.getContentPane().add(label_8);

		label_9 = new JLabel("零售价：");
		label_9.setBounds(57, 122, 85, 15);
		frame.getContentPane().add(label_9);

		t_units = new JTextField();
		t_units.setColumns(10);
		t_units.setBounds(140, 75, 127, 21);
		frame.getContentPane().add(t_units);

		t_stockPrice = new JTextField();
		t_stockPrice.setColumns(10);
		t_stockPrice.setBounds(421, 75, 127, 21);
		frame.getContentPane().add(t_stockPrice);

		t_associatorPrice = new JTextField();
		t_associatorPrice.setColumns(10);
		t_associatorPrice.setBounds(421, 119, 127, 21);
		frame.getContentPane().add(t_associatorPrice);

		t_retailPrice = new JTextField();
		t_retailPrice.setColumns(10);
		t_retailPrice.setBounds(140, 119, 127, 21);
		frame.getContentPane().add(t_retailPrice);

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

		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setBounds(558, 122, 16, 15);
		frame.getContentPane().add(label_5);
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
			 String goodsName = t_goodsName.getText();
			 String goodsBewrite = t_goodsBewrite.getText();
			 String units = t_units.getText();
			 String stockPriceStr = t_stockPrice.getText();
			 String associatorPriceStr = t_associatorPrice.getText();
			 String retailPriceStr = t_retailPrice.getText();
			 //String 字符串装换为double类型
			 
			 if (goodsName.equals("") || goodsBewrite.equals("") ||  units.equals("") || stockPriceStr.equals("") || associatorPriceStr.equals("") || retailPriceStr.equals("") ){
				 JOptionPane.showMessageDialog(null, "请将商品信息补充完整！", "提示", JOptionPane.ERROR_MESSAGE);
				 return ;
			 }
			 double stockPrice = 0.0;
			 double retailPrice = 0.0;
			 double associatorPrice =0.0 ;
			 try {
				 stockPrice = Double.parseDouble(stockPriceStr);
				  retailPrice = Double.parseDouble(retailPriceStr);
				  associatorPrice = Double.parseDouble(associatorPriceStr);
			} catch (NumberFormatException e2) {
				t_stockPrice.setText("");
				t_associatorPrice.setText("");
				t_retailPrice.setText("");
				 JOptionPane.showMessageDialog(null, "请输入合法数字！", "警告", JOptionPane.ERROR_MESSAGE);
				 return;
			}
			 
			 Goods goods = new Goods(null, goodsName, goodsBewrite, units, stockPrice, retailPrice, associatorPrice);
			 dao.addGoods(goods);
			 
			GoodsPanel.table.removeAll();
			GoodsPanel.table.setModel(new GoodsTableModel());
			 frame.setVisible(false);
			 
		}

	}
}
