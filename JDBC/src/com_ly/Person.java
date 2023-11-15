package com_ly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbc","root","root");
			Statement statement=connection.createStatement();
			statement.execute("insert into person values(2302,'pimple')");
			connection.close();
			System.out.println("data stored");
			} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

}
