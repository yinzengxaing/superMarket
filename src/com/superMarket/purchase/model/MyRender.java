package com.superMarket.purchase.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.superMarket.baseFile.warehouse.bean.Warehouse;
import com.superMarket.baseFile.warehouse.dao.WarehouseDao;
import com.superMarket.baseFile.warehouse.dao.WarehouseDaoImpl;
import com.superMarket.purchase.dao.PurchaseDao;
import com.superMarket.purchase.dao.PurchaseDaoImpl;
import com.superMarket.purchase.view.PurchasePanel;

public class MyRender extends AbstractCellEditor implements TableCellRenderer, ActionListener, TableCellEditor {
	private static final long serialVersionUID = 1L;
	private JButton button ;
	private PurchaseDao purchaseDao = new PurchaseDaoImpl();
	private WarehouseDao warehouseDao = new WarehouseDaoImpl();

	


	@Override
	public Object getCellEditorValue() {
		return null;
	}

	/**
	 * 对按钮进行编辑
	 */

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		button = new JButton();
		
		// value 源于editor
		String text = (value == null) ? "" : value.toString();
		button.setForeground(Color.blue);
		
		// 按钮文字
		button.setText(text);
		
		
		if (text.equals("已入库")){
			button.setEnabled(false);

		}else{
			button.addActionListener(this);
		}

		return button;
	}

	/**
	 * 按钮点击事件
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		

	
		
		int row = PurchasePanel.table.getSelectedRow();
		String id = (String)PurchasePanel.table.getValueAt(row, 1);
	
	//	System.out.println(id);
		
		
		/**
		 * 获取库房信息
		 */
		List<Warehouse> list = warehouseDao.getWarehouseList();
		Object[] possibleValues = new Object[list.size()];
		
		Map<String, String> house = new HashMap<String,String>();
		
		for (int i=0; i<list.size(); i++) { 
			possibleValues[i] = list.get(i).getName();
			house.put(list.get(i).getName(), list.get(i).getId());
		 }
		
		
		
		Object selectedValue = JOptionPane.showInputDialog(null, "请选择一个仓库", "选择仓库", 
		JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
		
		if (selectedValue != null){
			purchaseDao.updateIsStack(id);
			String warehouseId = house.get(selectedValue);
			purchaseDao.inStack(id, warehouseId);
			
		}
		
		PurchasePanel.table.removeAll();
		PurchasePanel.table.setModel(new PurchaseTableModel());
		PurchasePanel.table.getColumnModel().getColumn(0).setCellEditor(new MyRender());//设置编辑器
		PurchasePanel.table.getColumnModel().getColumn(0).setCellRenderer(new MyRender());
		
		

	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

		//table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
	
		// value 源于editor
		String text = (value == null) ? "" : value.toString();
		button = new JButton();

		// 按钮文字
		button.setText(text);
		//System.out.println(text);
		if (text.equals("已入库")){
			button.setEnabled(false);
			
		}else{
			button.addActionListener(this);
		}
		return button;
	}
	

}