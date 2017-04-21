/** 
 * hollowworld! 
 */ 
package com.appx;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.ArrayList; 
import java.util.HashSet; 
import java.util.Scanner; 

 
class SocketList { 
   ArrayList socketList = new ArrayList() ; 
} 

public class Server { 
	static PrintWriter p = null; 
  /** 
   * @param args 
   */ 
  public static ArrayList socketList = new ArrayList() ; 
   
  public static String combineStr(String str){ 
    String tempStr = ""; 
    for ( int i = 0; i < str.length() ; i++ ) 
      tempStr += str.substring(i, i+1); 
    return tempStr; 
  } 
  public static void start(){ 
    try { 
       
      ServerSocket s = new ServerSocket(1234); 
      System.out.println("server lis"); 
      while(true){ 
        Socket ss = s.accept(); 
        socketList.add(ss); 
        new MyChatServer(ss,new Server()).start(); 
      } 
    } catch (IOException e) { 
      e.printStackTrace(); 
    }  
    
  } 

  
  public static void main(String[] args) { 
    
    start(); 
  }
public static void bootcast(String resverStr) {
	for(Object soc : socketList){
  		try {
			p = new PrintWriter(((Socket) soc).getOutputStream() , true );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        p.println(resverStr); 
  	 }
	
} 

}