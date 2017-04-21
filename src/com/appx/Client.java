/** 
 * hollowworld! 
 */ 
package com.appx;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter; 
import java.net.Socket; 
import java.net.UnknownHostException; 
import java.util.Scanner; 

/** 
 * @author user 
 * 
 */ 
public class Client { 

  /** 
   * @param args 
   * @throws IOException  
   * @throws UnknownHostException  
   */ 
  public static void main(String[] args) throws UnknownHostException, IOException {
	//ObjectOutputStream opt = new ObjectOutputStream();
	  
    Socket s = new Socket("127.0.0.1" , 1234); 
    Scanner sc = new Scanner(System.in); 
    String inputStr = ""; 
    PrintWriter p = null; 
    BufferedReader b= null;     
    while( !inputStr.equals("exit") ){ 
       
      inputStr = sc.next(); 
      p = new PrintWriter(s.getOutputStream() , true); 
      p.println(inputStr);     
       
      b = new BufferedReader( 
         new InputStreamReader( s.getInputStream() ) 
      ); 
      System.out.println("clientSend : " + b.readLine()); 
      //System.out.print(b.readLine()); 

       
    } 
    b.close(); 
    p.close();    
     
  } 

}