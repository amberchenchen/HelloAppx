package com.appx;

public class Dec01_Interface {

	public static void test(Flyable f){
		f.fly();
		if(f instanceof Bird){
			Bird b = (Bird)f;
			b.hatch();
			b.eat();
		}
	}
	
	public static void main(String[] args) {
		
		//YourCar yc = new YourCar();
		//MyCar mc = new MyCar(); abstract 
		
		Bird b = new Bird();
		test(b);
		SuperMan s = new SuperMan();
		test(s);
	

	}

}
