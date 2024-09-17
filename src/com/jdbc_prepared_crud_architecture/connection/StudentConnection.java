package com.jdbc_prepared_crud_architecture.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentConnection {

	public static Connection getStudentConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

}
