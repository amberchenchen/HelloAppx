package com.appx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;




public class testSwing extends JFrame {

	private JPanel contentPane;
	private static boolean hasChange = false;
	static String fileName = null;
	private JTextField textField;
	static JTextArea textArea = new JTextArea();
	static testSwing frame = new testSwing();
	static int searchIndex = 0;
	static JFileChooser chooser = new JFileChooser();
	static Toolkit toolkit = Toolkit.getDefaultToolkit();
	static Clipboard clipboard = toolkit.getSystemClipboard();
	/**
	 * Launch the application.
	 */

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						if(hasChange){
							int result = JOptionPane.showConfirmDialog(null, "Do you want to save the chages", "save", JOptionPane.CANCEL_OPTION);
							if(result == JOptionPane.YES_OPTION){
								save(textArea.getText());
							}
						}
					}
				});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public testSwing() {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 466);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("FIle");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setIcon(new ImageIcon("/Users/amberchen/Downloads/exit.gif"));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				save(textArea.getText());
				
				hasChange = false;
				
			}
		});
		
		JMenuItem mntmOpenFile = new JMenuItem("Open File");
		mntmOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
				    chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(frame);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				       chooser.getSelectedFile().getPath();
				       fileName = chooser.getSelectedFile().getPath();
				       
				       try (FileInputStream fi = new FileInputStream(fileName)){			
							String ss=""; 
							int i = fi.read();
							while(i != -1){					
								ss +=(char)i;
								i = fi.read();
							}
							textArea.setText(ss);
							hasChange = false;
							
						} 
						catch (IOException e1) {
							e1.printStackTrace();
						}
				    }
				
			}
		});
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hasChange){
					int result = JOptionPane.showConfirmDialog(null, "Do you want to save the chages", "save", JOptionPane.CANCEL_OPTION);
					if(result == JOptionPane.YES_OPTION){
						save(textArea.getText());
					}
				}
				textArea.setText("");
				fileName = null;
			}
		});
		mnFile.add(mntmNew);
		mnFile.add(mntmOpenFile);
		mnFile.add(mntmSave);
		
		JMenuItem mntmNewFile = new JMenuItem("Exit");
		mntmNewFile.setIcon(new ImageIcon("/Users/amberchen/Downloads/images.png"));
		mntmNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DO_NOTHING_ON_CLOSE);				
			}
		});
		mnFile.add(mntmNewFile);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				 StringSelection strselect = new StringSelection(textArea.getSelectedText());
				 clipboard.setContents(strselect, null);
							
			}
		});
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Transferable clp =clipboard.getContents(null);
				 try {
					String str = (String)clp.getTransferData(DataFlavor.stringFlavor);
					textArea.setText(textArea.getText()+str);
					
				} catch (UnsupportedFlavorException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnEdit.add(mntmPaste);
		
		JButton btnAboutAs = new JButton("About As");
		btnAboutAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "我們是時賦科技");
			}
		});
		menuBar.add(btnAboutAs);
		
		JButton btnBrowser = new JButton("Browser");
		btnBrowser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				URL google = null;
				BufferedReader in = null;
				try {
					google = new URL("https://tw.yahoo.com");
				} catch (MalformedURLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					in  = new BufferedReader(new InputStreamReader(google.openStream()));
					String result = null;
					String temp = null;
					while((temp = in.readLine())!= null){
						result += temp;
					}
					
					textArea.setText(result);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		menuBar.add(btnBrowser);
		
		textField = new JTextField();
		menuBar.add(textField);
		textField.setBounds(209, 232, 130, 26);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		menuBar.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>0 && textArea.getText().indexOf(textField.getText())!=-1){
					 find(textArea.getText(),textField.getText());
				}
			}
		});
		
		
		
		btnSearch.setBounds(333, 232, 117, 29);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
//		contentPane.setLayout(null);
//		contentPane.add(btnOk);
		
//		JPanel jp = new JPanel();
//		jp.setLayout(new FlowLayout());
		
		contentPane.setLayout(new BorderLayout());
		
		JLabel lblWordCount = new JLabel("Word Count");
		contentPane.add(lblWordCount, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
		scrollPane.setViewportView(textArea);
		
		class MyDocumentListener implements DocumentListener{

			@Override
			public void insertUpdate(DocumentEvent e) {
				hasChange = true;
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				hasChange = true;
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				hasChange = true;
				
			}
			
		}
		
		
	}
	
	public void find(String textarea,String textfield){
	
		int start = textarea.indexOf(textfield,searchIndex);
		if(start==-1){
			JOptionPane.showMessageDialog(null, "Last char");
		}
		
		textArea.setSelectionStart(start);
		textArea.setSelectionEnd(start + textfield.length());
		searchIndex = start + textfield.length();
		textArea.setSelectedTextColor(Color.RED);
	}
	
	public static void save(String s){
		if(fileName==null){
			int returnVal = chooser.showSaveDialog(frame);
			if(returnVal== JFileChooser.APPROVE_OPTION){
				fileName = chooser.getSelectedFile().getPath();
			}
		}
		PrintWriter pr = null;
		try {
			pr =new PrintWriter(fileName);
			pr.print(s);				
			JOptionPane.showMessageDialog(null, "success");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}finally{
			pr.close();
		}
	}
}
