package customer_pack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveTheData {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/studentdetails","root","root");
			PreparedStatement preparedStatement=
			connection.prepareStatement("select *from student where phonenumber like ?");
			preparedStatement.setString(1,"%00");
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+"  "
									+resultSet.getString(2)+"  "
									+resultSet.getInt(3)+"  "
									+resultSet.getString(4)+" "
									+resultSet.getInt(5)+" "
									+resultSet.getInt(6)
									);
			}
			preparedStatement.execute();
			connection.close();
			System.out.println("data retriving plzz wait...");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
//	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdetails","root","root");
//			PreparedStatement preparedStatement=connection.prepareStatement("select *from student where marks>? and age>?");
//			preparedStatement.setInt(1, 80);
//			preparedStatement.setInt(2,22);
//			ResultSet resultSet=preparedStatement.executeQuery();
//			
//			while(resultSet.next())
//			{
//				System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2)+"  "+resultSet.getInt(3)+"  "+resultSet.getString(4)+" "+resultSet.getInt(5)+" "+resultSet.getInt(6));
//			}
//			preparedStatement.execute();
//			System.out.println("data retriving plzz wait...");
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}

}
