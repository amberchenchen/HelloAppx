package com.appx;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.PreparedStatement.ParseInfo;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.annotation.Generated;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class table extends JFrame {

	private JPanel contentPane;
	private static JTable table;	
	
	private JTextField Id;
	private JTextField Name;
	private JTextField Department;
	private JTextField Position;
	private JTextField Salary;
	private JComboBox Gender;
	EmployeeDao employeeDao = new EmployeeDao();

	// 建立連線
//	Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.60.112/appx_test", "test", "test");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {							
				try {
					table frame = new table();										
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public void loadData() throws ClassNotFoundException, SQLException  {
		
		EmployeeList empModelList = employeeDao.Read();		
		
		table.setModel(new AbstractTableModel() {
			
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				employeeModel empModel = empModelList.empModel.get(rowIndex);
				
				switch(columnIndex){
					case 0:
						return empModel.getId();
					case 1:
						return empModel.getName();
					case 2:
						return empModel.getGender();
					case 3:
						return empModel.getDepartment();
					case 4:
						return empModel.getPosition();
					case 5:
						return empModel.getSalary();
				}
				
				return null;
			}
					
			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return empModelList.empModel.size();
			}
			
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return empModelList.ColumnName.length;
			}
			
			@Override
			public String getColumnName(int columnIndex){
				  return empModelList.ColumnName[columnIndex];
			}
		});
	}
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public table() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 438, 141);
		contentPane.add(scrollPane);
								
		table = new JTable();
				
		scrollPane.setViewportView(table);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(6, 159, 22, 16);
		contentPane.add(lblId);
		
		Id = new JTextField();
		Id.setBounds(61, 154, 130, 26);
		contentPane.add(Id);
		Id.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(6, 189, 61, 16);
		contentPane.add(lblName);
		
		Name = new JTextField();
		Name.setBounds(61, 184, 130, 26);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(6, 222, 61, 16);
		contentPane.add(lblGender);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(219, 159, 78, 16);
		contentPane.add(lblDepartment);
		
		Department = new JTextField();
		Department.setBounds(314, 154, 130, 26);
		contentPane.add(Department);
		Department.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(219, 189, 61, 16);
		contentPane.add(lblPosition);
		
		Position = new JTextField();
		Position.setBounds(314, 184, 130, 26);
		contentPane.add(Position);
		Position.setColumns(10);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(219, 222, 61, 16);
		contentPane.add(lblSalary);
		
		Salary = new JTextField();
		Salary.setBounds(314, 217, 130, 26);
		contentPane.add(Salary);
		Salary.setColumns(10);
		
		Gender =new JComboBox();
		Gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		Gender.setBounds(61, 217, 130, 27);
		contentPane.add(Gender);
		
		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadData();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnReload.setBounds(0, 250, 101, 29);
		contentPane.add(btnReload);
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeModel empADD = new employeeModel();				
				empADD.name = Name.getText();
				empADD.gender = Gender.getSelectedItem().toString();
				empADD.position = Position.getText();
				empADD.department = Department.getText();
				empADD.salary = Salary.getText();
				try {
					employeeDao.Add(empADD);
					loadData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnAddNew.setBounds(107, 250, 117, 29);
		contentPane.add(btnAddNew);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeModel empADD = new employeeModel();	
				empADD.id = Integer.parseInt(Id.getText());
				empADD.name = Name.getText();
				empADD.gender = Gender.getSelectedItem().toString();
				empADD.position = Position.getText();
				empADD.department = Department.getText();
				empADD.salary = Salary.getText();
				try {
					employeeDao.update(empADD);
					loadData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(229, 250, 88, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					employeeDao.delete(Integer.parseInt(Id.getText()));
					loadData();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(327, 250, 117, 29);
		contentPane.add(btnDelete);
		
		loadData();			
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedindex = table.getSelectedRow();
				if(selectedindex > 0){
				Id.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				Name.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				Gender.setSelectedItem(table.getValueAt(table.getSelectedRow(), 2));
				Department.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				Position.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				Salary.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				}
			}
		});
	}

}
