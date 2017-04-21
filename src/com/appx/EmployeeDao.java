package com.appx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	
	public Connection conn;
	public int columncount;
	public String[] columnName;
	public List<EmployeeList> model = new ArrayList<EmployeeList>();
	public EmployeeDao() throws SQLException{
		conn = DriverManager.getConnection("jdbc:mysql://192.168.60.112/appx_test", "test", "test");
	}
	
	public EmployeeList Read() throws SQLException{
		
		PreparedStatement pstmt =
				conn.prepareStatement("select * from employee");
		ResultSet rs = pstmt.executeQuery();
		
		columncount = rs.getMetaData().getColumnCount();
		columnName = new String[columncount];
		
		for(int c=0;c<columncount;c++){
			columnName[c] = rs.getMetaData().getColumnName(c+1);			
		}
		
		EmployeeList emp = new EmployeeList();
		emp.empModel = new ArrayList<employeeModel>();
		emp.ColumnName = columnName;
		while (rs.next()){		
			employeeModel empmodel = new employeeModel();
			empmodel.id = rs.getInt("id");
			empmodel.name = rs.getString("name");
			empmodel.gender = rs.getString("gender");
			empmodel.department = rs.getString("department");
			empmodel.position = rs.getString("position");
			empmodel.salary = rs.getString("salary");
			emp.empModel.add(empmodel);
			model.add(emp);
		}
		
		return emp;
	}

	public void Add(employeeModel e) throws SQLException{
		PreparedStatement 
			pstmt = conn.prepareStatement("insert into employee(name,gender,department,position,salary) values(?,?,?,?,?)");
		pstmt.setNString(1, e.name);
		pstmt.setNString(2, e.gender);
		pstmt.setNString(3, e.department);
		pstmt.setNString(4, e.position);
		pstmt.setNString(5, e.salary);
		pstmt.executeUpdate();
	}
	
	public void update(employeeModel e) throws SQLException{
		PreparedStatement pstmt = conn.prepareStatement("update employee set name=?,gender=?,department=?,position=?,salary=? where id=?");
		pstmt.setNString(1, e.name);
		pstmt.setNString(2, e.gender);
		pstmt.setNString(3, e.department);
		pstmt.setNString(4, e.position);
		pstmt.setNString(5, e.salary);
		pstmt.setInt(6, e.id);
		pstmt.executeUpdate();
	}
	
	public void delete(int id) throws SQLException{
		PreparedStatement pstmt = conn.prepareStatement("delete from employee  where id=?");
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
	}

}
