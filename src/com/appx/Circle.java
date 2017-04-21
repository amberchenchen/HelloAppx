package com.appx;

public class Circle extends MyPoint{
	int r;
	double area;
	float Length;
	private double pei = 3.14;
	

	Circle(int x,int y) {
		
	}
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	public void printArea(){
		this.area = r*r*pei;
		System.out.println("Area = "+(r*r*pei)); 
	}
	
	public void printLength(){
		this.Length = (float)(2*pei*r);
		//System.out.println("Length = "+ (float)(2*pei*r));
	}
	
	public void print(){
		
		System.out.println(getLocation() + "r = "+r);
	}

}
