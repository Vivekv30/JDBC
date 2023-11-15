package com.ly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedet","root","root");
			Statement statement=connection.createStatement();
			statement.execute("insert into employee values(106,'vivek',77999,'developer')");
			//statement.execute("update employee set eid=10 where ename='tanvi'");
			//statement.execute("delete from employee where eid=106");

			connection.close();
			System.out.println("data updated");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
