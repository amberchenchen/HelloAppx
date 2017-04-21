/** 
 * hollowworld! 
 */ 
package com.appx; 

import java.awt.Color; 
import java.awt.FlowLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
import java.io.BufferedReader; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.PrintWriter; 

import javax.swing.*; 

/** 
 * @author user 
 * 
 */ 
public class Note { 

  //JFileChoos 彈出視窗 
  public static void main(String[] args) { 
    String filepath = "/Users/amberchen/Desktop/test.txt";
    JFrame jf = new JFrame("note"); 
    JButton saveBtn = new JButton("save file"); 
    JButton loadBtn = new JButton("load file"); 
    JButton searchBtn = new JButton("search"); 
    JTextField  jserchText = new JTextField(20); 
    JTextArea jtextArea = new JTextArea("",25,60); 
    String[] arr = {"yes","no"}; 
    jf.setTitle("notepad"); 
    jf.setSize(700,700); 
    jf.setVisible(true); 
    jf.setDefaultCloseOperation(3);      
    jf.setLayout(new FlowLayout());  
     
     
    jf.setLayout(new FlowLayout());  
     
     
    jf.add(jtextArea);  
    jf.add(saveBtn);  
    jf.add(loadBtn);  
    jf.add(jserchText);         
    jf.add(searchBtn);            
    jf.addWindowListener(new WindowAdapter(){ 
      public void windowClosing(WindowEvent e){ 
        int rev = JOptionPane.showOptionDialog(null, "do you want to save file ?","confirm",JOptionPane.DEFAULT_OPTION,  
            JOptionPane.YES_NO_CANCEL_OPTION, null,arr , 0); 
        if( rev== 0 ) { 
          try { 
            PrintWriter pw = new PrintWriter(filepath); 
            pw.println(    jtextArea.getText()); 
            pw.close(); 
          } catch (FileNotFoundException e1) { 
            e1.printStackTrace(); 
          }       
        }   
      } 
       
    });   
    searchBtn.addActionListener( 
        new ActionListener(){ 
            public void actionPerformed(ActionEvent e){ 
                int  selectStartIdx = jtextArea.getText().indexOf(  jserchText.getText() ); 
                int  selectEndIdx = jserchText.getText().length(); 
                System.out.println( selectStartIdx +"  " +selectEndIdx ); 
                
               // jtextArea.setSelectionStart( selectStartIdx ); 
               // jtextArea.setSelectionEnd(  selectStartIdx + selectEndIdx ); 
                jtextArea.setSelectedTextColor(Color.RED); 
                jtextArea.setSelectionColor(Color.BLUE); 
                jtextArea.setSelectionStart( 0 ); 
                jtextArea.setSelectionEnd( 3 );                                             

            } 
        } 
         
    ); 
     
    saveBtn.addActionListener( 
        new ActionListener(){ 
          public void actionPerformed(ActionEvent e){ 
            int rev = JOptionPane.showConfirmDialog(null, "do you want to save file ?","confirm",1); 
            if( rev == 0 ){ 
              PrintWriter pw = null ; 
              try { 
                pw = new PrintWriter(filepath); 
                pw.println(jtextArea.getText());                 
              } catch (FileNotFoundException e1) { 
                e1.printStackTrace(); 
              }finally{ 
                 pw.close(); 
              } 
            } 
             
         }       
        } 
    );     

     
    loadBtn.addActionListener( 
        new ActionListener(){ 
          public void actionPerformed(ActionEvent e){ 

            // jdk 7 以後支援,在try....cetch節速前會確保括弧中的物件已被關閉 
            // 括弧裡的物件 需有直接或間接的實作 AutoCloseable 
            try ( FileInputStream in = new FileInputStream(filepath) ) {               
               
              int line = in.read(); 
              String text = "" ; 
              for ( ; line != -1 ; ){ 
                System.out.print( (char)line); 
                text += (char)line; 
                line = in.read();                 
              } 
              jtextArea.setText(text);              
               
            //} catch (FileNotFoundException e1) { >> FileNotFoundException 為  IOException的子類別 可以省略 且cetch 不可放在 IOException 後面 
            //  e1.printStackTrace(); 
            } catch (IOException e1) { 
              e1.printStackTrace(); 
            }         
             
//            jdk 7 前的用法             
//            FileInputStream in = null; 
//            try { 
//              //BufferedReader in= new BufferedReader(new FileReader(filepath)); 
//              //String line = in.readLine(); 
//              in = new FileInputStream(filepath); 
//               
//              int line = in.read(); 
//              for ( ; line != -1 ; ){ 
//                System.out.print( (char)line); 
//                line = in.read();                 
//              } 
//              //jta.setText(line.toString());              
//               
//            } catch (IOException e1) { 
//              e1.printStackTrace(); 
//            }finally{ 
//              try { 
//                in.close(); 
//              } catch (IOException e1) {                 
//                e1.printStackTrace(); 
//              } 
//            } 
             
         } 

          private char[] toChars(int line) { 
            // TODO Auto-generated method stub 
            return null; 
          }       
        } 
    );     
     
    
    //jf.addWindowListener(new MyWin()); 
     
     
  } 

}