package com.superMarket.baseFile;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.superMarket.baseFile.duty.view.DutyPanel;
import com.superMarket.baseFile.goods.view.GoodsPanel;
import com.superMarket.baseFile.seller.view.SellerPanel;
import com.superMarket.baseFile.supplier.view.SupplierPanel;
import com.superMarket.baseFile.warehouse.view.WarehousePanel;

import javax.swing.JTree;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;

public class BaseFilePanel extends JPanel  {


	private JTree tree;
	//供货商panel
	private SupplierPanel supplierPanel = new SupplierPanel();
	//销售商panel
	private SellerPanel sellerPanel = new SellerPanel();
	//货品panel
	private GoodsPanel goodsPanel = new GoodsPanel();
	//职务的panel
	private DutyPanel dutyPanel = new DutyPanel();
	//库管的panel
	private WarehousePanel  warehousePanel = new WarehousePanel();
	
	
	private JPanel panel;
	public BaseFilePanel() {
		this.getContentPanel();
	}
	public void getContentPanel()  {
			this.setBorder(BorderFactory.createTitledBorder(null, "基本档案管理", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.TOP, new Font("微软雅黑", Font.BOLD, 12), null));			
			setLayout(null);
			
			JPanel tree_panel = new JPanel();
			tree_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			tree_panel.setBounds(0, 20, 162, 700);
			add(tree_panel);
			tree_panel.setLayout(null);
			
			
			DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("基本档案管理");
			// 创建子节点
			DefaultMutableTreeNode childNode_supplier = new DefaultMutableTreeNode("供货商管理");
			DefaultMutableTreeNode childNode_retailer = new DefaultMutableTreeNode("销售商管理");
			DefaultMutableTreeNode childNode_googs = new DefaultMutableTreeNode("货品档案管理");
			DefaultMutableTreeNode childNode_stack = new DefaultMutableTreeNode("仓库管理");
			DefaultMutableTreeNode childNode_job = new DefaultMutableTreeNode("职务管理");

			// rootNode加入子节点
			rootNode.add(childNode_supplier);
			rootNode.add(childNode_retailer);
			rootNode.add(childNode_googs);
			rootNode.add(childNode_stack);
			rootNode.add(childNode_job);
			
			tree = new JTree(rootNode);
			tree.setBounds(10, 10, 142, 339);
			tree_panel.add(tree);
			//为树加上监听器
			tree.addTreeSelectionListener(new TreeListener());
			
		    panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBounds(167, 20, 1000, 700);
			add(panel);
			panel.setLayout(new BorderLayout(0, 0));
	}
	
	
	/**
	 * 树形图的事件监听器
	 * 
	 * @author 惠普
	 *
	 */
	public class TreeListener implements TreeSelectionListener {

		@Override
		public void valueChanged(TreeSelectionEvent e) {

			if (e.getSource() == tree) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				// 判断节点
				if (node.isLeaf()) {
					String nodeStr = node.toString();
				//	System.out.println(nodeStr);
					// 选中供货管理模块
					if ("供货商管理".equals(nodeStr)) {
						
						//对供货商信息进行显示
						JPanel supplier_panel = supplierPanel.getSupplierPanel();
						panel.removeAll();
						panel.add(supplier_panel);
						panel.validate();
						panel.repaint();

					} else if ("销售商管理".equals(nodeStr)) {
						
						//对销售商信息进行显示
						JPanel seller_panel = sellerPanel.getSellerPanel();
						panel.removeAll();
						panel.add(seller_panel);
						panel.validate();
						panel.repaint();

					} else if ("货品档案管理".equals(nodeStr)) {

						//对货品档案进行管理显示
						JPanel goods_panel = goodsPanel.getGoodsPanel();
						panel.removeAll();
						panel.add(goods_panel);
						panel.validate();
						panel.repaint();
						
						
					} else if ("仓库管理".equals(nodeStr)) {
						//对仓库管理进行显示
						JPanel warehouse_panel = warehousePanel.getWarehousePanel();
						panel.removeAll();
						panel.add(warehouse_panel);
						panel.validate();
						panel.repaint();
						
						

					} else if ("职务管理".equals(nodeStr)) {
						//对职务管理进行显示
						JPanel duty_panel = dutyPanel.getDutyPanel();
						panel.removeAll();
						panel.add(duty_panel);
						panel.validate();
						panel.repaint();
					}
				}
			}

		}

	}
	
}
