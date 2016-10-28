package com.appx;

public class Test2 {

	static boolean test1(){
		System.out.println("Test1");
		return true;
		
	}
	
	static boolean test2(){
		System.out.println("Test2");
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(test1() && test2()){
			System.out.println("Good");
		}
		
		if(test1() || test2()){
			System.out.println("BAD");
			
		}

	}

}
