package samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAll {
	public static void main(String[]args){
		try(
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abctrading?useSSL=false", "myUser","clientpass");
				Statement stm = conn.createStatement();
			)
			{
				String strSelect = "describe products";
				System.out.println("The sql query is: " + strSelect); // echo for debugging
				System.out.println();
				
				ResultSet resultSet = stm.executeQuery(strSelect);
				while(resultSet.next()){
					System.out.print(resultSet.getString(1) + " ");
					System.out.println(resultSet.getString(2));
				}
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			} 
	}
}
