package com.ly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RetrivingData {

	public static void main(String[] args) {
		Scanner ip=new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select *from employeetab ");
//			System.out.println("enter phno");
//			preparedStatement.setInt(1, ip.nextInt());
//			System.out.println("enter salary");
//			preparedStatement.setInt(2, ip.nextInt());
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+"  "
						+resultSet.getString(2)+"  "
						+resultSet.getInt(3)+"  "
						+resultSet.getInt(4)+" "
						+resultSet.getInt(5)+" "
						+resultSet.getString(6)
						);
			}
			
			
			
			preparedStatement.execute();
			connection.close();
			ip.close();
			System.out.println("......................data retrieved...................");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
