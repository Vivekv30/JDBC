package com.ly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Hotel {

	public static void main(String[] args) {
		Scanner ip=new Scanner(System.in);
		boolean repeat=true;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","root");
			do
			{
				System.out.println("1.Add Menu\n2.Delete Menu\n3.update Menu\n4.Get All Menu\n5.Get the menu by item\n6.Exit");
				System.out.println("enter your choice 1to 6");
				int ch=ip.nextInt();
				switch(ch)
				{
				case 1:{
					PreparedStatement preparedStatement=connection.prepareStatement("insert into hotel values(?,?,?,?,?,?)");
					System.out.println("enter id");
					preparedStatement.setInt(1, ip.nextInt());
					System.out.println("enter name");
					preparedStatement.setString(2, ip.next());
					System.out.println("enter cost");
					preparedStatement.setInt(3, ip.nextInt());
					System.out.println("enter quantity");
					preparedStatement.setInt(4, ip.nextInt());
					System.out.println("enter quality");
					preparedStatement.setString(5, ip.next());
					System.out.println("enter services");
					preparedStatement.setString(6, ip.next());
					preparedStatement.execute();
				}
				System.out.println("items added successfully");break;
				case 2:{
					PreparedStatement preparedStatement=connection.prepareStatement("delete from hotel where id=?");
					System.out.println("enter currect id");
					preparedStatement.setInt(1, ip.nextInt());

					preparedStatement.execute();
					System.out.println("item removed successfully");
				}break;
				case 3:{
					PreparedStatement preparedStatement=connection.prepareStatement("update hotel set cost=? where id=?");
					System.out.println("enter id");
					preparedStatement.setInt(2, ip.nextInt());
					System.out.println("enter name");
					preparedStatement.setString(1, ip.next());
					
					preparedStatement.execute();
					}System.out.println("item updated successfully");break;
				case 4:{
					PreparedStatement preparedStatement=connection.prepareStatement("select *from hotel ");
					ResultSet resultSet=preparedStatement.executeQuery();
					System.out.println(".................List of items....................");
					System.out.println("___________________________________________________");	
					while(resultSet.next())
						{
						String s=" "+resultSet.getInt(1)+"    "+resultSet.getString(2);
						String s1=resultSet.getInt(3)+"      "+resultSet.getInt(4)+"     "+resultSet.getString(5)+"   "+resultSet.getString(6);
						
						System.out.printf("%-25s%15s%n",s,s1);
//						System.out.println(
//								 resultSet.getInt(1)+"    "
//								+resultSet.getString(2)+"     "
//								+resultSet.getInt(3)+"    "
//								+resultSet.getInt(4)+"    "
//								+resultSet.getString(5)+"   "
//								+resultSet.getString(6)
//								);
						}
						System.out.println("___________________________________________________");
						preparedStatement.execute();
						};break;
				case 5:{
					PreparedStatement preparedStatement=connection.prepareStatement("select *from hotel where id=?");
					System.out.println("enter item id");
					preparedStatement.setInt(1, ip.nextInt());
					ResultSet resultSet=preparedStatement.executeQuery();
					while(resultSet.next())
					{
						System.out.println("___________________________________________________");
					System.out.println(
							 resultSet.getInt(1)+"  "
							+resultSet.getString(2)+"  "
							+resultSet.getInt(3)+"  "
							+resultSet.getInt(4)+" "
							+resultSet.getString(5)+" "
							+resultSet.getString(6)
							);
					}
					System.out.println("___________________________________________________");
					preparedStatement.execute();
					};break;
				
				case 6:{
					repeat=false;
					System.out.println("ThankYou \nVisit Again");
					}break;
				default :System.out.println("invalid choice");
				}
			}while(repeat);
			connection.close();
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


//😄 😃 😀 😍😞 😡 😤 💀 💕 ❤
