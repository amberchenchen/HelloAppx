package com.appx;

public class Nov08_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car c1 = new Car();
		//c1.brand = "BMW";
		System.out.println("C1 Brand = " + c1.brand);
		System.out.println("C1 Speed = " + c1.speed);
		c1.speedup();
		System.out.println("After C1 Speed = " + c1.speed);
		c1.speeddown();
		c1.speeddown();
		c1.speeddown();
		c1.speeddown();
		c1.speeddown();
		
		System.out.println("C1 speed Down = " + c1.speed);
		
		
		Car c2 = new Car();
		c2.brand = "Benz";
		System.out.println("C2 Brand = " + c2.brand);
		
		
		MyPoint p1 = new MyPoint();
		MyPoint p3 = new MyPoint(666);//帶參數建構子
		MyPoint p4 = new MyPoint(6,8);//帶參數建構子
		System.out.println("Constructor p1 = "+p1.x);
		System.out.println("Constructor p3 = "+p3.x);
		p4.print();
		p1.setX(6);
		System.out.println("P1 X = "+p1.getX());
		p1.setY(7);
		System.out.println("P1 Y = "+p1.getY());
		
		MyPoint p2 = new MyPoint();
		p2.print();

	}

}
