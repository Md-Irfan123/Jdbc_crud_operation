package com.jdbc_prepared_crud_architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc_prepared_crud_architecture.connection.StudentConnection;
import com.jdbc_prepared_crud_architecture.dto.Student;

public class StudentDao {

	Connection connection = StudentConnection.getStudentConnection();

	public Student saveStudentDao(Student student) {
		String insertQueryStudent = "insert into student1 values(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(insertQueryStudent);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setLong(4, student.getPhone());
			ps.execute();
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Student getStudentByIdDao(int studentId) {
		
		String selectQuery="Select * from student1 where id=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(selectQuery);
			ps.setInt(1, studentId);
			
			ResultSet resultSet=ps.executeQuery();
			
			if(resultSet.next())
			{
				int id=resultSet.getInt("id");
				String name=  resultSet.getString("name");
				String email = resultSet.getString("email");
				long phone = resultSet.getLong("phone");
				
				return new Student(id, name, email, phone);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public List<Student>getAllStudentDao(){
		String selectQuery= "select * from student";
		
		try {
			PreparedStatement ps=connection.prepareStatement(selectQuery);
			ResultSet rs=ps.executeQuery();
			
			List<Student> st=new ArrayList<Student>();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=  rs.getString("name");
				String email = rs.getString("email");
				long phone = rs.getLong("phone");
				
				Student student=new  Student(id,name,email,phone);
				st.add(student);
			}
			return st;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int updateStudentNameIdDao(int id,String name) {
		String UpdateQuery="update student set name=? where id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(UpdateQuery);
			ps.setInt(2, id);
			ps.setString(1,name);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

}
