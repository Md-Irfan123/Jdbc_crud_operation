package com.jdbc_prepared_crud_architecture.controller;

import java.util.List;
import java.util.Scanner;

import com.jdbc_prepared_crud_architecture.dto.Student;
import com.jdbc_prepared_crud_architecture.service.StudentService;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		StudentService service = new StudentService();
		
		while (true) {
			System.out.println("1.Insert\n2.getById\n3.Update\n4.Display\n5.Exit");
			System.out.println("Select your option");
			int ch = scanner.nextInt();

			switch (ch) {
			case 1: {
				System.out.println("enter student id");
				int id = scanner.nextInt();
				System.out.println("enter student name");
				String name = scanner.next();
				System.out.println("enter student email");
				String email = scanner.next();
				System.out.println("enter student phone");
				long phone = scanner.nextLong();
				
				Student student = new Student(id, name, email, phone);
				
				Student st=service.saveStudentService(student);
				
				if(st!=null) {
					System.out.println("data inserted");
				}else {
					System.out.println("data not inserted");
				}
			}
				break;

			case 2: {
				System.out.println("enter student id to display");
				int id = scanner.nextInt();
				Student student=service.getStudentByIdService(id);
				
				if(student!=null) {
					System.out.println(student);
				}else {
					System.err.println("given id is not found or check with sql query");
				}
				
			}
				break;
			
			case 3: {
				System.out.println("Enter student id to update the name");
				int id=scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Enter New Student name:");
				String name=scanner.nextLine();
				
				int a=service.updateStudentNameByIdService(id, name);
				 
				if(a==1) {
					System.out.println("Data updated");
					
				
			}
				else {
					System.out.println("given id is not found or check sql query");
				}
			}
			break;
			case 4: {
				List<Student> st=service.getAllStudentService();
				if(st!=null) {
					for(Student student: st)
						System.out.println(student);
						
				}
				
			
			else {
				System.out.println("There is no data available.........or check with sql");
			}
		}
			break;
		}
	}


	}
}
