package samples;

import java.sql.*;

public class SumUpTest {
	public static void main(String[]args){
		
		try(
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abctrading?useSSL=false", "myUser", "clientpass");
				Statement statement = connection.createStatement();
		)
		{
				String updateQuery = "update products set name = 'Pen with Bluetooth' where name like '%blue%'";
				getAll();
				int rowsAffected = statement.executeUpdate(updateQuery);
				System.out.println("The query was: " + updateQuery);
				System.out.println("Rows affected: " + rowsAffected);
				getAll();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private static void getAll(){
		try(
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abctrading?useSSL=false", "myUser", "clientpass");
				Statement statement = connection.createStatement();
		)
		{
				String selectAll = "select * from products";
				ResultSet set = statement.executeQuery(selectAll);
				
				int id;
				String category;
				String name;
				int quantity;
				float price;
				while(set.next()){
					id = set.getInt(1);
					category = set.getString(2);
					name = set.getString(3);
					quantity = set.getInt(4);
					price = set.getFloat(5);
					System.out.printf("%d %s %s %d %f%n", id, category, name, quantity, price);
				}
				
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
