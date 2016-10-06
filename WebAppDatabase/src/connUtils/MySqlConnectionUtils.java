package connUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionUtils {
	
	public static Connection getMySqlConnection() throws SQLException{
		String hostName = "localhost";
		String dbName = "webdb";
		String userName = "myUser";
		String password = "clientpass";
		return getMySqlConnection(hostName, dbName, userName, password);
	}
	
	public static Connection getMySqlConnection(String hostName, String dbName,
			String userName, String password) throws SQLException{
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName; 
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(connectionURL, userName, password);
			return conn;
		}
		catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}
}
