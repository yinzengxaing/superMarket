package com.superMarket.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;


public class ImgPanel extends Panel {

	private static final long serialVersionUID = 1L;
	 Image img 		 ;
	 public ImgPanel(String imgPath  ) {
		 img = Toolkit.getDefaultToolkit().createImage(imgPath);
	 }
	 	 
	 //重写paint方法将图片画进去
	 /* (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(img,0, 0,img.getWidth(null),img.getHeight(null), this);
		super.paint(g);
	}
}
