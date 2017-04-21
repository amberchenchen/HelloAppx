package com.appx;

import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

//import com.mysql.jdbc.Connection;

public class JDBCTEST {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 載入driver
		Class.forName("com.mysql.jdbc.Driver");

		// 建立連線
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.60.112/appx_test", "test", "test");

		// rollback set commit false
		conn.setAutoCommit(false);

		Scanner sc = new Scanner(System.in);
		System.out.println("Location : ");
		String location = sc.next();
		System.out.println("Name : ");
		String name = sc.next();

		// 建立查詢
		PreparedStatement pstmt =
				// conn.prepareStatement("Update user set location = ? where id
				// = ?");
				conn.prepareStatement("insert into user(name,location) values(?,?)");

		pstmt.setNString(1, name);
		pstmt.setNString(2, location);

		PreparedStatement pstmt2 =
				// conn.prepareStatement("Update user set location = ? where id
				// = ?");
				conn.prepareStatement("insert into user(name,location) values(?,?)");
		pstmt2.setNString(1, null);
		pstmt2.setNString(2, location);

		// 修改資料
		try {
			pstmt.executeUpdate();
			pstmt2.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			conn.rollback();
		}

		// 執行查詢
		ResultSet rs = pstmt.executeQuery("select * from user");

		int columnCount = rs.getMetaData().getColumnCount();

		// 執行結果
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				String columnValue = rs.getString(rs.getMetaData().getColumnName(i));
				System.out.format("%s ", columnValue);
			}
			System.out.println();
			// int id = rs.getInt("id");
			// String name = rs.getString("name");
			// String location = rs.getString("Location");
			// System.out.format("%s %s %s%n", id,name,location);
		}

		rs.close();
		pstmt.close();
		conn.close();

	}

}
