package com.appx;

import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter an Integer Number From 1 to 15");
		int num = sc.nextInt(); 
		
		for(int i=1 ; i<=num ;i++){
			for(int j=num;j>=-(num-1); j--){
				if(i<j){
					System.out.print("\t");
				}
				else{
					//j 是負的 表示開始印右邊 0跳過不印 (-1 -2 -3 -4 -5)右邊
					if(j!=0 && -j<i){
						if(j<0){
							System.out.print(-j +1 +"\t");//因為是加一 所以上面條件要小於自己本身
						}
						else{
							System.out.print(j +"\t");
						}
					}				
				}
			}
			System.out.println();
		}		
	}

}
