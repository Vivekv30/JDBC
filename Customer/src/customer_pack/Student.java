package customer_pack;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/studentdetails","root","root");
			PreparedStatement preparedStatement=
			connection.prepareStatement("insert into student values (?,?,?,?,?,?)");
			preparedStatement.setInt(1,108);
			preparedStatement.setString(2,"mani");
			preparedStatement.setInt(3, 25);
			preparedStatement.setString(4,"male");
			preparedStatement.setInt(5,95);
			preparedStatement.setLong(6, 9094889000l);
			preparedStatement.execute();
			connection.close();
			System.out.println("data saved");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
