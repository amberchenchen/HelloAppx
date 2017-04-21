package com.appx;

import java.util.Scanner;

public class test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int ans = 135;
		String ansStr = Integer.toString(ans);
		
		boolean isRight = false;
		while(!isRight){
			System.out.print("Enter Number : ");
			int num = sc.nextInt();
			String numStr = Integer.toString(num);
			int aSum = 0;
			int bSum = 0;
			
			if(num == ans){
				isRight = true;
				System.out.println("Bingo");
			}
			else{
				for(int i=0; i<numStr.length() ;i++){
					for(int j=0; j<ansStr.length() ;j++){
						if(numStr.charAt(i)==ansStr.charAt(j) && i==j){
							aSum ++;
						}
						else if(numStr.charAt(i)==ansStr.charAt(j)){
							bSum ++;
						}
					}
				}
				System.out.println(aSum +" a " + bSum +" b ");
			}
			
			
		}

	}

}
