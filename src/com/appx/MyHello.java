package com.appx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;

class MyThread extends Thread{
	Socket s;
	public Socket ss ; 
	MyThread( Socket socket ){ 
	    ss = socket ; 
	  } 
	  public void run(){ 
	     
	    try { 
	      PrintWriter p = null; 
	      BufferedReader b= null; 
	      String inputStr = "";     
	      while( !inputStr.equals("exit") ){  

	        b = new BufferedReader( 
	            new InputStreamReader( ss.getInputStream() ) 
	         );        
	         inputStr = b.readLine(); 
	         String resverStr = new StringBuffer(inputStr).reverse().toString(); 
	         System.out.println("serviceSend : "+resverStr);      
	         p = new PrintWriter(ss.getOutputStream() ,  true); 
	         p.println(resverStr); 
	        

	      } 
	      b.close(); 
	      p.close();          
	    }catch(IOException e){ 
	       
	    } 
	    
	  }
}

public class MyHello {

	public static void main(String[] args) {
//		MyThread mt1 = new MyThread();
//		MyThread mt2 = new MyThread();
//		mt1.start();
//		mt2.start();
		
		ArrayList al = new ArrayList();
		al.add(1);
		al.add("A");
		al.add("A");
		
		al.add(3);
		
//		System.out.println(al.indexOf("A"));
		HashSet hs = new HashSet();
		//hs.add(1);
		hs.add("1");
		hs.add("2");
		hs.add(new MyPoint());
//		System.out.println("MyPoint hashCode1 = " + new MyPoint().hashCode());
		hs.add(new MyPoint());
//		System.out.println("MyPoint hashCode2 = " + new MyPoint().hashCode());
		System.out.println(hs);
		
		
	}	

}
