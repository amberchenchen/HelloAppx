package com.appx;

import javax.swing.text.html.parser.Parser;

public class Nov08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("args Length = " + args.length);
		double sum=0;
		
		for(int i=0;i<args.length;i++){
			//sum += Integer.parseInt(args[i]);
			sum += Double.parseDouble(args[i]);
		}
		System.out.println(sum);
		System.out.println();
		//加強版loop
		for(String w : args){
			System.out.println(w);
		}
		

	}

}
