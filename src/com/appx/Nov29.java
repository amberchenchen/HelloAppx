package com.appx;

public class Nov29 {

	static void test(MyPoint mp) {

		if (mp instanceof Circle) {
			Circle cc = (Circle) mp;
			cc.printArea();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(MyPoint.getCount());
		MyPoint p1 = new Circle(1,3);
		test(p1);
		// MyPoint p2 = new Cylinder(1, 1);
		// test(p2);

		MyPoint pp = new MyPoint();
		test(pp);
		System.out.println(pp);
		
		MyPoint p3 = new MyPoint();
		MyPoint p4 = new MyPoint();
		System.out.println("Static Count = "+MyPoint.count);
		System.out.println(Math.PI);

	}

}
