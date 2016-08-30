package samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectTest {
	public static void main(String[]args){
		
		try(
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?useSSL=false", "myUser","clientpass");
			Statement stm = conn.createStatement();
		)
		{
			String strSelect = "select title, price, quantity from books";
			System.out.println("The sql query is: " + strSelect); // echo for debugging
			System.out.println();
			
			ResultSet resultSet = stm.executeQuery(strSelect);
			
			System.out.println("The records selected are:");
			int numberOfRecords = 0;
			while(resultSet.next()){
				String title = resultSet.getString("title");
				float price = resultSet.getFloat("price");
				int quantity = resultSet.getInt("quantity");
				
				System.out.printf("%50s %20f %20d%n", title, price, quantity);
				numberOfRecords++;
			}
			System.out.println("Total number of records is: " + numberOfRecords);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		// closing resources done automatically thanks to try with res block
	}
}
