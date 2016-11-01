package com.appx;

import java.lang.Math;
import java.lang.System;

public class Oct27_1 {
	//可回傳值的function
	public static int test(int a,int b){
		
		int sum=0;
		for(int i=a ; i<=b ;i++){
			sum = sum + i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
//		int sum = test(1,6);
//		System.out.println("Sum = " + sum);
//		
//		int max = Math.max(55, 99);
//		System.out.println("Max Value = "+ max);
//		
//		int min = Math.min(55, 99);
//		System.out.println("Min value = " + min);
//		
//		double sqrt = Math.sqrt(2.0); //開耕號
//		System.out.println("Sqrt = " + sqrt);
//		
//		double pow = Math.pow(2, 3); //次方
//		System.out.println("Pow = " + pow);

		for(int i=0;i<6;i++){
			double random = Math.random()*50 +1;
			System.out.print((int)random + "  ");
		}

	}
}
