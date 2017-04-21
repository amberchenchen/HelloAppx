package com.appx;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Cylinder extends Circle  {
	int h;
	NumberFormat nf = new DecimalFormat(".0");
	
	Cylinder(int r,int h){
		super(r,h);
		this.setR(r);
		this.printArea();
		this.printLength();
		this.h=h;
	}
	
	public void printVolume(){
		
		System.out.println("printVolume = "+nf.format(this.area * h));
	}
	
	public void printCylinderLength(){
		
		System.out.println("printCylinderLength = "+nf.format(this.Length *2));
	}
	
	public void printSurface(){
		System.out.println("printSurface = "+ nf.format((this.area *2)+(this.Length*h)));
	}
	
//private void print(){
//		
//		//System.out.println(getLocation() + "r = "+r);
//	}

}
