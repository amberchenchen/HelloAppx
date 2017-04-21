package com.appx;

import javax.swing.JFrame;

import test.MyTest;

public class Nov15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.format("test1 = %.1f%n",Math.PI);
//		System.out.format("test2 = %s,hhh,%s","a","v");
		nov24 no = new nov24();
		MyPoint mp = new MyPoint();
		System.out.println("obj mp = "+ mp.toSting());
		
		Cylinder cy = new Cylinder(3,8);
		cy.printVolume();
		cy.printSurface();
		cy.printCylinderLength();
		
//		Circle c1 = new Circle(10);
//		c1.printArea();
//		c1.printLength();
//		c1.print();
		
//		MyTest mt = new MyTest();
//		mt.a2=1; //只呼叫得到a2 因為只有他宣告成public 
		
//		c1.print();
//		
		JFrame jf = new JFrame();
		jf.setSize(500, 500);
		jf.setTitle("Title");
		jf.setDefaultCloseOperation(3);
		jf.setVisible(true);

	}

}
