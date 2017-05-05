package com.superMarket.baseFile.supplier.test;

import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
public class TestJTabbedPane {
 public static void main(String[] args) {
    new MyFrame(); 
 }
}
class MyFrame extends JFrame{
 JPanel jp=new JPanel();
 JTabbedPane jtp =new JTabbedPane();
 public MyFrame(){
  JPanel JButtonJP =new JPanel();
  JButtonJP.add(new JButton("按钮1"));
  JButtonJP.add(new JButton("按钮2"));
  JButtonJP.add(new JButton("按钮3"));
 
     JPanel  JLabelJP= new JPanel();
     JLabelJP.add(new JLabel("标签一"));
     JLabelJP.add(new JLabel("标签二"));
     JLabelJP.add(new JLabel("标签三"));
     
     jtp.add("JButtonJP", JButtonJP);
     jtp.add("JLabelJP", JLabelJP);
     jp.add(jtp);
     this.add(jp);
     this.setTitle("选项卡JTabbedPane的使用");
     this.addWindowListener(new WindowAdapter(){
      public void windowClosing(){
       System.exit(0);
      }
     });
     this.setSize(500,400);
     this.setVisible(true);
 }
}