package com.charan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CharanServiceImpl implements CharanService {

	static Scanner ip= new Scanner(System.in);
	@Override
	public void save() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/charandatabase", "root", "root");//2
			Statement statement=connection.createStatement();//3
			boolean b=statement.execute("insert into person values (1,'vijay')");//4
			System.out.println("success");
			connection.close();//5

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/charandatabase", "root", "root");//2
			System.out.println("1.id\n2.name");

			switch(ip.nextInt()) {
			case 1:
				
			{
				PreparedStatement preparedStatement=connection.prepareStatement("update person set id=? where name=?");
				System.out.println("enter name");
				ip.nextLine();
				preparedStatement.setString(2, ip.nextLine());//upto here 3//for 1st ? we have to pass id value(2) which is int type so use setInt
				System.out.println("enter id");
				preparedStatement.setInt(1, ip.nextInt());
				preparedStatement.execute();//4
			}break;
			case 2:
			{
				PreparedStatement preparedStatement=connection.prepareStatement("update person set name=? where id=?");
				System.out.println("enter id");
				preparedStatement.setInt(2, ip.nextInt());
				System.out.println("enter name");
				preparedStatement.setString(1, ip.nextLine());//upto here 3//for 1st ? we have to pass id value(2) which is int type so use setInt
				preparedStatement.execute();//4
			}break;
			default :System.out.println("invalid");
			}

			System.out.println("updated successfully");
			connection.close();//5

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/charandatabase", "root", "root");//2
			PreparedStatement preparedStatement=connection.prepareStatement("delete from person where id=?");
			System.out.println("enter id");
			preparedStatement.setInt(1, ip.nextInt());//upto here 3//for 1st ? we have to pass id value(2) which is int type so use setInt

			preparedStatement.execute();//4
			System.out.println("success");
			connection.close();//5

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/charandatabase", "root", "root");//2
			PreparedStatement preparedStatement=connection.prepareStatement("select * from person");//3
			ResultSet resultSet = preparedStatement.executeQuery();//will return set of data in ResultSet(Interface)//4

			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"       "+resultSet.getString(2));
			}
			//			System.out.println(resultSet);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getById() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/charandatabase", "root", "root");//2
			PreparedStatement preparedStatement=connection.prepareStatement("select * from person where id=?");//3
			System.out.println("enter id");
			preparedStatement.setInt(1, ip.nextInt());//3

			ResultSet resultSet = preparedStatement.executeQuery();//will return set of data in ResultSet(Interface)//4

			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"       "+resultSet.getString(2));
			}
			//			System.out.println(resultSet);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}
