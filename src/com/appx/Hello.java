
/**
 * JavaDoc 文件註解
 * @author amberchen
 * @since 2016-10-13
 */

package com.appx;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		// double to float
		int tempC = 1; 
		int tempCC = 100; 
		double op1 = (double)9/5;
		int op2 = 32;
		double tempF = tempC * op1 + op2;
		double tempFF = tempCC * op1 + op2;
		System.out.println("攝氏1度＝ "+ tempF);
		System.out.println("攝氏100度＝ "+ tempFF);
		
		int x=1,y,z=1,k=1;
		y=x++;
		System.out.println("x++ = "+y);
		y=++z;
		System.out.println("++x = "+y);
		y=1+ ++k;
		System.out.println("1+ ++k = "+y);
		
		int i=2,j;
		j=i<<29;
		System.out.println("i<<2 = "+j);
		
		//印二進位
		System.out.println(Integer.toBinaryString(-1));
		int grade=60;
		if(grade % 2 == 0){
			System.out.println("Even");
		}
		else{
			System.out.println("Odd");
		}
		
		Scanner sc = new Scanner(System.in);
		int score1 = sc.nextInt();
		int score2 = sc.nextInt();
		int a = score1+score2;
		int b = score1-score2;
		int c = score1*score2;
		double d = (double)score1/score2;
		int e = score1%score2;
		System.out.println("+ = "+a);
		System.out.println("- = "+b);
		System.out.println("* = "+c);
		System.out.println("/ = "+d);
		System.out.println("% = "+e);
		
	}

}
