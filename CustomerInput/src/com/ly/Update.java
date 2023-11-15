package com.ly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
Scanner ip=new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("update employeetab set id=? where name=?");
			System.out.println("enter id");
			preparedStatement.setInt(1, ip.nextInt());
			System.out.println("enter name");
			preparedStatement.setString(2, ip.next());
			
			preparedStatement.execute();
			connection.close();
			ip.close();
			System.out.println("data updated");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
