package com.appx;

import java.util.Scanner;

public class Oct25_2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//判斷是否質數
		System.out.println("Please enter a number more than 1");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		boolean isPrime = true;
		if(num==1){
			isPrime = false;
		}
		for(int i=2 ; i<num;i++){
			if(num%i==0){				
				isPrime = false;
				break;
			}
		}
		
		if(!isPrime){
			System.out.println("不是質數");
		}
		else{
			System.out.println("是質數");
		}

	}

}
