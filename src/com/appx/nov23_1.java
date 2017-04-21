package com.appx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

class win extends WindowAdapter{
	public void windowIconified(WindowEvent e)
	{
		System.out.println("Change.....");
	}
	public void windowClosing(WindowEvent e){
		System.out.println("Bye.....");
	}
}

 class MyAction implements ActionListener{

	public void actionPerformed(ActionEvent e){
		System.out.println("hi");
		JOptionPane.showMessageDialog(null, "yes");
		JOptionPane.showConfirmDialog(null, "sure?", "click", JOptionPane.CANCEL_OPTION);
		JOptionPane.showInputDialog("Input");
		
	}
 }

public class nov23_1 {

	public static void main(String[] args) {
//		Myframe mf = new Myframe();
//		mf.setVisible(true);
//		mf.addWindowListener(new win());
		
		JFrame jf = new JFrame("title");
		jf.setSize(500, 500);	
		jf.add(new JTextArea());
		jf.setVisible(true);
//		JButton jb = new JButton("Button");
//		jb.setSize(100, 100);
		//jb.addActionListener(new MyAction());
//		jb.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				jf.setTitle("20161213");				
//				
//			}
//		});
		//jf.add(jb);
		
		jf.setDefaultCloseOperation(3);
		//jf.addWindowListener(new win());
//		jf.addWindowListener(new WindowAdapter() {
//			public void windowIconified(WindowEvent e)
//			{
//				System.out.println("Change.....");
//			}
//			public void windowClosing(WindowEvent e){
//				System.out.println("Bye.....");
//			}
//		});
	}

}
