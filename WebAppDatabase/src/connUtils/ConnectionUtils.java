package connUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
	
	public static Connection getConnectionToDatabase(){
		try{
			Connection con =  MySqlConnectionUtils.getMySqlConnection();
			return con;
		}
		catch(SQLException e){
			int errorCode = e.getErrorCode();
			System.out.println("Error "+ errorCode +" occured when establishing connection to database");
			return null;
		}
	}
	
	public static void closeQuietly(Connection conn){
		try{
			if(conn != null){
				conn.close();
			}
		}
		catch(SQLException e){
		}
	}
	
	public static void rollBackQuietly(Connection conn){
		if(conn != null){
			try {
				conn.rollback();
			} catch (SQLException e) {
			}
		}
	}
}
