package com.appx;

import java.util.Scanner;

public class test4 {

	
	public static String generatePassword( int length, int minNumericLength, int minCharLength, int minSymbolLength) { 

		int numberCnt=0,charCnt=0,symbolCnt=0,cnt=0;		
		String Password="";
		while(cnt < length){
			double pswNum =  Math.random()*94+33;
			if((int)pswNum>=48 && (int)pswNum<=57){
				if(numberCnt!=minNumericLength){
					Password += (char)pswNum ;
					numberCnt++;
					cnt++;
				}
			}
			else if(((int)pswNum>=65 && (int)pswNum<=90) || ((int)pswNum>=97 && (int)pswNum<=122)){
				 if(charCnt!=minCharLength){
					Password += (char)pswNum ;
					charCnt++;
					cnt++;
				 }
			}
			else if(symbolCnt!=minSymbolLength){
				Password += (char)pswNum ;
				symbolCnt++; 
				cnt++;
			}
			
			if(numberCnt==minNumericLength && charCnt==minCharLength && charCnt==minCharLength && cnt < length){
				Password += (char)pswNum ;
				cnt++;
			}
		}		
		return Password;
		
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner sc = new Scanner(System.in);
		System.out.print("設定密碼長度: ");
		int length = sc.nextInt();
		System.out.print("設定密碼數字最少次數: ");
		int minNumericLength = sc.nextInt();
		System.out.print("設定密碼字母最少次數 : ");
		int minCharLength = sc.nextInt();
		System.out.print("設定密碼特殊符號最少次數 : ");
		int minSymbolLength = sc.nextInt();

		if((minNumericLength+minCharLength+minSymbolLength) >length){
			System.out.println("密碼長度與條件不符合");
		}
		else{
			String Password = generatePassword(length,minNumericLength,minCharLength,minSymbolLength);
			System.out.println(Password);
		}

	}

}
