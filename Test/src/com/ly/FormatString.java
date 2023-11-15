package com.ly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormatString {
	public static void main(String[] args) {
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
	
	
}
