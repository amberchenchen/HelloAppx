package com.appx;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Paint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame jf = new JFrame("Paint");
		jf.setSize(500, 500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(3);

		jf.addMouseMotionListener(new MouseAdapter() {
				
			public void mouseMoved(MouseEvent e){
				jf.getGraphics().drawString(".", e.getX(), e.getY());
				jf.getGraphics().draw3DRect(12,24, 100, 100, true);
				System.out.println("(" +e.getX() +","+ e.getY() + ")");
			}
			
			public void mouseDragged(MouseEvent e){
				System.out.println("mouseDragged");
			}
			
		});
		
		jf.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				System.out.println("mouseExited");
				
			}
			
			public void mouseEntered(MouseEvent e) {
				System.out.println("mouseEntered");
				
			}
			
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked");
				
			}	
		});
	}

}
