package samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteInsertTest {
	public static void main(String[]args){
		try(
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?useSSL=false" , "myUser", "clientpass");	
			Statement statement = connection.createStatement();
			)
		{
			String deleteStm = "delete from books where quantity > 40";
			System.out.println("The sql query is: " + deleteStm);
			int countDeleted = statement.executeUpdate(deleteStm);
			System.out.println("Rows affected: " + countDeleted);
			
			//Insert a record 
			String insertStm = "insert into books values " + 
							 " (1005, 'Testing stuff is cool', 'Thack Collins',14.56, 500)";
			System.out.println("The sql query is: " + insertStm);
			int countInserted = statement.executeUpdate(insertStm);
			System.out.println("Rows inserted: " + countInserted);
			
			//inserting mulitple rows
			String insertStm2 = "insert into books values " + 
								" (1006, 'Testing stuff is cool', 'Thack Collins',14.56, 500), " +
								"(1007, 'W pustyni i w puszczy', 'Sienkiewicz Henryk', 67.56, 2), "	+
								"(1008, 'Colly Pocolo ', 'Jay Sweet',1.56, 300)";
			System.out.println("The sql query is: " + insertStm2);
			int countInserted2 = statement.executeUpdate(insertStm2);
			System.out.println("Rows inserted: " + countInserted2);
			
			insertStm = "insert into books (id, title, author) " + 
					 " values (1009, 'Full or empty', 'Artist')";
			System.out.println("The sql query is: " + insertStm);
			countInserted = statement.executeUpdate(insertStm);
			System.out.println("Rows inserted: " + countInserted);
			
			//getting result set
			String selectAll = "select * from books";
			System.out.println("Query is: " + selectAll);
			ResultSet res = statement.executeQuery(selectAll);
			while(res.next()){
				System.out.print(res.getInt(1) + " ");
				System.out.print(res.getString(2) + " ");
				System.out.print(res.getString(3) + " ");
				System.out.print(res.getFloat(4) + " ");
				System.out.print(res.getInt(5) + " ");
				System.out.println();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
