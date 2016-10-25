package com.appx;

import java.util.Scanner;

public class Oct25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//99乘法表
		for(int i=1 ;i<10 ;i++){
			for(int j=1;j<10;j++){
				System.out.print(i +"*"+ j + "=" + (i*j) + "\t");
				
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i=1 ;i<10 ;i++){
			for(int j=1;j<i+1;j++){
				System.out.print(i +"*"+ j + "=" + (i*j) + "\t");
				
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=1 ;i<10 ;i++){
			for(int j=1;j<10;j++){
			if(i>j)
				System.out.print("\t");
			else{
					System.out.print(i +"*"+ j + "=" + (i*j) + "\t");
			}
				
			}
			System.out.println();
		}
		
		System.out.println();
		int i=1;
		int j=0;
		while(i<11){
			System.out.print(i +" ");
			j=i+j;			
			i++;		
		}
		System.out.println();
		System.out.println("1~10相加 = "+j);
		
		int k=100;
		do{
			System.out.println("Do While 至少都會執行一次不管條件對不對");
		}while(k<10);
		
		System.out.println();
		int enter ;
		do{
			System.out.println("Please Enter");
			Scanner sc = new Scanner(System.in);
			enter = sc.nextInt();
		}while(enter!=0);
		
			
	}

}
