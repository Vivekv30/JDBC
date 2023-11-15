package customer_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/studentdetails","root","root");
			PreparedStatement preparedStatement=
				connection.prepareStatement("update student set ename=? where id=?");
			preparedStatement.setInt(2, 101);
			preparedStatement.setString(1,"sunny");
			preparedStatement.execute();
			connection.close();
			System.out.println("data updated");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
