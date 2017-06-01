package com.superMarket.outStock;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.superMarket.inStock.view.InWarehousePanel;
import com.superMarket.outStock.view.OutWarehousePanel;
public class BaseOutWarehousePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTree tree;

	public BaseOutWarehousePanel() {

		this.getContentPanel();
	}

	public void getContentPanel() {
		this.setBorder(BorderFactory.createTitledBorder(null, "出库管理", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.TOP, new Font("微软雅黑", Font.BOLD, 12), null));
		setLayout(null);

		JPanel tree_panel = new JPanel();
		tree_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tree_panel.setBounds(0, 20, 162, 700);
		add(tree_panel);
		tree_panel.setLayout(null);

		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("出库管理");
		// 创建子节点
		DefaultMutableTreeNode childNode_purchase = new DefaultMutableTreeNode("出库管理");

		// rootNode加入子节点
		rootNode.add(childNode_purchase);

		tree = new JTree(rootNode);
		tree.setBounds(10, 10, 142, 339);
		tree_panel.add(tree);
		// 为树加上监听器
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
					// 选中供货管理模块
					if ("出库管理".equals(nodeStr)) {
						OutWarehousePanel outWarehousePanel = new OutWarehousePanel();
						JPanel panel2 = outWarehousePanel.getPanel();
						panel.removeAll();
						panel.add(panel2);
						panel.validate();
						panel.repaint();
					
						

					}
				}

			}

		}
	}
}
