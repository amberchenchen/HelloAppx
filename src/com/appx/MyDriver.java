package com.appx;

import com.appx.MyOuter.MyInner;

class MyOuter{
	int i=1;
	
	 //class MyInner{
	static class MyInner{
		double d;
		int i=2;
		void printInner(){
			System.out.println(d);//inner 
			System.out.println(i);//inner
			//System.out.println(MyOuter.this.i); // outer
			
		}
	}
	
	void test(){
		MyInner mi = new MyInner(); //#1
		//System.out.println(d); 必須要有inner 物件才能存取到d
	}
}

public class MyDriver {

	public static void main(String[] args) {
		MyOuter mo = new MyOuter();
		
		MyOuter.MyInner mi = new MyOuter.MyInner();//#2
		mi.printInner();
	}

}
