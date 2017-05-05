package com.superMarket.purchase.model;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class MyRender extends AbstractCellEditor implements TableCellRenderer,ActionListener, TableCellEditor{

    private static final long serialVersionUID = 1L;
    private JButton button = null;

    
    
   public MyRender(){
        button = new JButton();
        button.addActionListener(this);
       
    }
 
@Override
    public Object getCellEditorValue() {
        // TODO Auto-generated method stub
        return null;
    }
 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
    	
    	 
        return button;
    }
 
@Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
	button.setText("已入库");
	button.setEnabled(false);
	JOptionPane.showMessageDialog(null, "已入库", "消息", JOptionPane.OK_OPTION);
	
        
         
    }
 
@Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
	
	System.out.println(row+"========="+column);
	
	
        return button;
    }
}