package com.appx;

import java.util.Scanner;

public class Oct25_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ans=65;		
		int number;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Please Enter");
			
			number = sc.nextInt();
			if(number>ans){
				System.out.println("too BIG");
			}			
			else if(number<ans){
				System.out.println("too Small");
			}
			else if(number==ans){
				System.out.println("Bingo");
			}
				
		}while(number!=ans);
	}

}
