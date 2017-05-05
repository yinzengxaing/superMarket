package com.superMarket.purchase.test;

import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.*;
import javax.swing.table.*;
 
public class TestTableCellRenderer extends JFrame{
 
    private static final long serialVersionUID = 1L;
    private JTable table = null;
    private MyModel model=null;
    private JScrollPane js=null ;
    public TestTableCellRenderer(){
        model = new MyModel();
        table = new JTable(model);
        table.getColumnModel().getColumn(7).setCellEditor(new MyRender());//设置编辑器
        table.getColumnModel().getColumn(7).setCellRenderer(new MyRender() );
        js = new JScrollPane(table);
 
this.add(js);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(399, 300);
        this.setLocationRelativeTo(null);
    }
 
public static void main(String[] args) {
        new TestTableCellRenderer();
    }
 

 
//渲染 器  编辑器
class MyRender extends AbstractCellEditor implements TableCellRenderer,ActionListener, TableCellEditor{

    private static final long serialVersionUID = 1L;
    private JButton button =null;
    
    private  int flage = 0;
    public MyRender(){
    	if (flage == 0){
        button = new JButton("未入库");
    	}else if (flage == 1) {
    		button = new JButton("已入库");
    		button.setEnabled(false);
    	}
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
        // TODO Auto-generated method stub
        return button;
    }
 
@Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
	
	JOptionPane.showMessageDialog(null, "已入库", "消息", JOptionPane.OK_OPTION);
	
        
         
    }
 
@Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        // TODO Auto-generated method stub
        return button;
    }
}
     
}