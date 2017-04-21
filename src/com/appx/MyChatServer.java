/** 
 * hollowworld! 
 */ 
package com.appx;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.Socket; 
import java.util.ArrayList; 

/** 
 * @author user 
 * 
 */ 
public class MyChatServer extends Thread { 
  public Socket ss ; 
  public Server server = new Server();
  MyChatServer( Socket socket, Server server){ 
    ss = socket ; 
    this.server = server;
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
         server.bootcast(resverStr);
         System.out.println("serviceSend : "+resverStr);      
         p = new PrintWriter( ss.getOutputStream() , true ); 
         p.println(resverStr); 
        

      } 
      b.close(); 
      p.close();          
    }catch(IOException e){ 
       
    } 
    
  } 
}