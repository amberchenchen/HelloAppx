package com.appx;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

class MyBrowser extends JFrame{
	WebView wv;
	JButton RefreshBtn = new JButton("Refresh"); 
	JButton NextBtn = new JButton("Next Page"); 
	JButton PrevBtn = new JButton("Prev Page");
	JButton SearchBtn = new JButton("Search"); 
	JFXPanel pane = new JFXPanel();
	List<String> urlList = new ArrayList<String>();
	JTextField jtext = new JTextField("https://www.google.com.tw/");
	
	public MyBrowser(){
		setLayout(new FlowLayout());
		jtext = new JTextField("https://www.google.com.tw/");
		add(RefreshBtn);  
		add(NextBtn);  
		add(PrevBtn);  
		add(jtext);  
		add(SearchBtn);
		setDefaultCloseOperation(3);  
		pane.setLayout(new BorderLayout());  
		add(pane);
		setVisible(true);
		setSize(800, 600);
		
		jtext.addActionListener( 
		        new ActionListener(){ 
		          public void actionPerformed(ActionEvent e){ 
		        	  load(jtext.getText());
		        	  urlList.add(jtext.getText());		        	 
		          }       
		       } 
		    );
		
		SearchBtn.addActionListener( 
		        new ActionListener(){ 
		          public void actionPerformed(ActionEvent e){ 
		        	  load(jtext.getText());   
		        	  urlList.add(jtext.getText());		     
		          }       
		       } 
		    ); 
		
		RefreshBtn.addActionListener( 
		        new ActionListener(){ 
		          public void actionPerformed(ActionEvent e){ 
		        	 String url = wv.getEngine().getLocation();
		        	 load(url);
		          }       
		       } 
		    );  
		
		PrevBtn.addActionListener( 
		        new ActionListener(){ 
		          public void actionPerformed(ActionEvent e){ 
		        	  WebHistory history = wv.getEngine().getHistory();
		        	  int currentIndex = history.getCurrentIndex();
		        	  load(history.getEntries().get(currentIndex - 1).getUrl());
		          }       
		       } 
		    );
		
		NextBtn.addActionListener( 
		        new ActionListener(){ 
		          public void actionPerformed(ActionEvent e){ 
		        	  WebHistory history = wv.getEngine().getHistory();
		        	  int currentIndex = history.getCurrentIndex();
		        	  System.out.println(history.getEntries().size() +" "+ currentIndex +"," + history.getEntries().get(currentIndex).getUrl());
		        	  load(history.getEntries().get(currentIndex).getUrl());
		          }       
		       } 
		    ); 
		
		jtext.addFocusListener(new FocusListener() {
		      public void focusGained(FocusEvent e) {
		        jtext.selectAll();
		      }

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
				}
			}
	      );
		
		jtext.getDocument().addDocumentListener(new DocumentListener() {
			

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				for(String s : urlList){
					boolean isContains = s.contains(jtext.getText());
					if(isContains){
						//jtext.removeAll();
						System.out.println(s);
						//jtext.setText(s);
						//load(s);
						load(s);
						break;
					}
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {			
			}
		});
		
			Platform.runLater(new Runnable() { 			
  			@Override
  			public void run() {
  				wv = new WebView();
  				pane.setScene(new Scene(wv));
  				
  			}
  		});
	}
	
	public  void load(String Url){
		Platform.runLater(new Runnable() {
  			
  			@Override
  			public void run() {
  				wv.getEngine().load(Url);				
  			}
  		});
	}	
}

public class JeditorPaneTest {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MyBrowser mb = new MyBrowser();
		
	}

}
