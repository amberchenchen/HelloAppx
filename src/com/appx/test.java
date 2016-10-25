package com.appx;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char grade = 'A';
		
		if(grade == 'A')
			System.out.println("90分");
		else if(grade == 'B')
			System.out.println("80分");
		else if(grade == 'C')
			System.out.println("70分");
		
		switch(grade){
			case 'A' :
				System.out.println("90");
				break;
			case 'B' :
				System.out.println("80");
				break;
			case 'C' :
				System.out.println("70");
				break;
			default:
				System.out.println("Error");
				break;
		}
		
//		for( int i=1;i<11;i++){
//			if(i<=9 && i>1)
//				System.out.print(",");
//			
//				System.out.print(i++);
//			
//		}
		
		for(int i=5 ; i<105 ; i=i+10){
			if(i>5 && i <105){
				System.out.print(",");
			}
			
			System.out.print(i);
		}

		System.out.println();
		
		for(int i=1 ; i<11 ; i++){
			if(i>1 && i <11){
				System.out.print(",");
			}
			
			System.out.print(5 + (i-1)*10 );
		}
		
		for(int i=1 ;i<10 ;i++){
			for(int j=1;j<10;j++){
				System.out.println(i +"*"+ j + " ");
			}
			System.out.println();
		}
		
	}

}
