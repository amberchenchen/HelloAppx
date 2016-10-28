package com.appx;

public class Oct27 {

	//區域變數(local variable)只會存在設定的function內,不能跨function
	static void test(int a,int b){
		int i=20;
		System.out.println("Test @i = " + i);
		System.out.println("Test @a = " + a);
		
	}
	
	
	
	static void test2(int a,int b){
		
//		int start,end;
//		if(a < b){
//			start = a;
//			end=b;
//		}
//		else{
//			start=b;
//			end=a;
//		}
//		for(int i=start;i<=end;i++){
//			System.out.print(i + " ");
//		}
		int tmp;
		if(a > b){
			tmp = a;
			a = b;
			b=tmp;
					
		}
		
		for(int i=a;i<=b;i++){
			System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i= 10,a=20;;
		System.out.println("Main Before @i = " + i);
		test(a,i);
		System.out.println("Main After @i = " + i);
		System.out.println();
		
		test2(5,9);
		System.out.println();
		test2(9,5);

	}

}
