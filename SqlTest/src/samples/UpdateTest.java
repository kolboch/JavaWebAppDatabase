package samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
	public static void main(String[]args){
		try(
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?useSSL=false", "myUser", "clientpass");
				Statement statement = connection.createStatement();
			)
		{
			String strUpdate = "update books set price = price * 0.8, quantity = quantity + 1 where id = 1001";
			int rowsUpdated = statement.executeUpdate(strUpdate);
			System.out.println(rowsUpdated + " numbers of rows affected.");
			
			String select = "select id, title, price, quantity from books where id = 1001";
			ResultSet resultSet = statement.executeQuery(select);
			System.out.println("Result of query:");
			while(resultSet.next()){
				int id = resultSet.getInt(1);
				String title = resultSet.getString(2);
				float price = resultSet.getFloat(3);
				int quant = resultSet.getInt(4);
				System.out.printf("%6d %20s %6f %6d%n", id, title, price, quant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
