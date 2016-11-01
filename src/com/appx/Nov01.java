package com.appx;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Nov01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 100;
		final int b = 101;//b++; final can not be modify
		final double d = 3.14;
		final float PI = 3.1416f;
		final char c = 'a';
		//Runtime Exception 執行時期出錯
		//**一維陣列宣告
		int[] numbers = {1,2,3,4,5,6,7};
		int[] num = new int[3]; //array int 預設是0 char 空直 boolean false
		for(int i=0;i<num.length;i++){
			System.out.print(num[i]+" ");
		}
		System.out.println();
		int data[] = new int[6];
		for(int i=0;i<data.length;i++){
			double random = Math.random()*49+1;
			data[i] = (int)random;
			for(int j=0;j<i;j++){				
				if(data[i]==data[j]){
					i--;
					break;
				}
			}			
		}		
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
		
		boolean dataB[] = new boolean[50];
		int data2[] = new int[6];
		for(int i=0;i<data2.length;i++){
			double random1 = Math.random()*49+1;

			if(!dataB[(int)random1]){
				data2[i]=(int)random1;
				dataB[(int)random1]=true;
			}
			else{
				
				i--;
			}
		}
		for(int i=0;i<data2.length;i++){
			System.out.print(data2[i]+" ");
		}

		
		//***二維陣列宣告 
		 int test[][] = new int[2][3];
		 //可以自訂後面的第二維陣列
		 int data22[][] = new int[2][];
		  data22[0] = new int[2];
		  data22[1] = new int[1];
	}

}
