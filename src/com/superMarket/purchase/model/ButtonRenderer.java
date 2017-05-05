package com.superMarket.purchase.model;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
/**
 * 是否入库出库的按钮渲染器
 * @author administrator
 *
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		  //value 源于editor
        String text = (value == null) ? "" : value.toString();
        //按钮文字
        setText(text);
        //单元格提示
        setToolTipText(text);
/*        //背景色
        setBackground(Color.BLACK);
        //前景色
        setForeground(Color.green);*/
      return this;
	}

}
