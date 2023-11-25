package com.ly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentImplementation implements StudentInterface {

	@Override
	public void saveStudent() {
		Scanner ip=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into student values (?,?,?,?,?)");
			System.out.println("enter the student id");
			preparedStatement.setInt(1,ip.nextInt());
			System.out.println("enter the student name");
			preparedStatement.setString(2,ip.next());
			System.out.println("enter the student age");
			preparedStatement.setInt(3,ip.nextInt());
			System.out.println("enter the student phone number");
			preparedStatement.setInt(4,ip.nextInt());
			System.out.println("enter the student marks");
			preparedStatement.setDouble(5,ip.nextDouble());
			preparedStatement.execute();
			connection.close();
			System.out.println("student data saved");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent() {
		Scanner ip=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("delete from student where id=?");
			System.out.println("enter the student id");
			preparedStatement.setInt(1,ip.nextInt());
			preparedStatement.execute();
			connection.close();
			System.out.println("data deleted");
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateStudent() {
		Scanner ip=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			System.out.println("which data you want to update\n1:id\n2:name\n3:age\n4:phno\n5:marks\nEnter your choice b/w 1 to 5");
			switch (ip.nextInt()) {
			case 1: {
				PreparedStatement preparedStatement=connection.prepareStatement("update student set id=? where name=? and phno=?");
				System.out.println("enter correct student name");
				preparedStatement.setString(2,ip.next());
				System.out.println("enter that student phone number");
				preparedStatement.setInt(3,ip.nextInt());
				System.out.println("entered data is correct\nenter student new id");
				preparedStatement.setInt(1,ip.nextInt());
				preparedStatement.execute();
			}break;
			case 2:{
				PreparedStatement preparedStatement=connection.prepareStatement("update student set name=? where id=?");
				System.out.println("enter the student id");
				preparedStatement.setInt(2,ip.nextInt());
				System.out.println("enter the student new name");
				preparedStatement.setString(1,ip.next());
				preparedStatement.execute();
			}break;
			case 3:{
				PreparedStatement preparedStatement=connection.prepareStatement("update student set age=? where id=?");
				System.out.println("enter the student id");
				preparedStatement.setInt(2,ip.nextInt());
				System.out.println("enter the student age");
				preparedStatement.setInt(1,ip.nextInt());
				preparedStatement.execute();
			}break;
			case 4:{
				PreparedStatement preparedStatement=connection.prepareStatement("update student set phno=? where id=?");
				System.out.println("enter the student id");
				preparedStatement.setInt(2,ip.nextInt());
				System.out.println("enter the student phone number");
				preparedStatement.setInt(1,ip.nextInt());
				preparedStatement.execute();
			}break;
			case 5:{
				PreparedStatement preparedStatement=connection.prepareStatement("update student set marks=? where id=?");
				System.out.println("enter the student id");
				preparedStatement.setInt(2,ip.nextInt());
				System.out.println("enter the student marks");
				preparedStatement.setDouble(1,ip.nextDouble());
				preparedStatement.execute();
			}break;
			default: System.out.println("invalid choice to update");
			}
			connection.close();
			System.out.println("data updated");
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select *from student ");
			ResultSet resultSet=preparedStatement.executeQuery();
			System.out.println("...............list of students.................\n______________________________________________");
			System.out.println("id |   name   |   age   |     phno     |  marks");
			System.out.println("______________________________________________");
			while(resultSet.next())
				{	
				String s=" "+resultSet.getInt(1)+"    "+resultSet.getString(2);
				String s1=resultSet.getInt(3)+"      "+resultSet.getInt(4)+"     "+resultSet.getDouble(5);
				System.out.printf("%-19s%5s%n",s,s1);
				}
			System.out.println("______________________________________________\n");
				preparedStatement.execute();
				connection.close();
		 }catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getStudentByMarks() {
		Scanner ip=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select *from student where marks=? ");
			System.out.println("enter student marks");
			double marks=ip.nextDouble();
			preparedStatement.setDouble(1,marks);
			ResultSet resultSet=preparedStatement.executeQuery();
			System.out.println("______________________________________________");
			System.out.println("id |   name   |   age   |     phno     |  marks");
			System.out.println("______________________________________________");
			
				while(resultSet.next())
				{
					System.out.println(
							 " "+resultSet.getInt(1)+"    "
							+resultSet.getString(2)+"     "
							+resultSet.getInt(3)+"       "
							+resultSet.getInt(4)+"      "
							+resultSet.getDouble(5));
			}
					System.out.println("______________________________________________");
				preparedStatement.execute();
				connection.close();
		 }catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}