package data_access_layer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbAccess {
	
	private static final String DRIVE_NAME = "com.mysql.jdbc.Driver";
		
	private static final String HOST_NAME = "bookstoredb.cxutrsepuguc.us-east-2.rds.amazonaws.com";
	
	private static final String DB_NAME = "bookstore";
	
	private static final String DB_CONNECTION_USERNAME = "csci4050";
	
	private static final String DB_CONNECTION_PASSWORD = "csci4050uga";
	
	private static Connection connect() {
		Connection connection = null;
		
		try {
			Class.forName(DRIVE_NAME);
			String jdbcUrl = "jdbc:mysql://" + HOST_NAME + ":" + "3306" + "/" + DB_NAME + "?user=" + DB_CONNECTION_USERNAME + "&password=" + DB_CONNECTION_PASSWORD;
		    connection = DriverManager.getConnection(jdbcUrl);
			
			System.out.println("Established a connection.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	//If rows = 0 after the code is ran, that means 0 rows were updated.
	public static int insert (String query) {
		Connection connection = connect();
		
		int rows = 0;
		
		try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(query);
			rows = stmt.executeUpdate();
			
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect(connection);
		
		return rows;
	}
	
	public static int delete(String query){
		return updateAndDelete(query);
	}
	
	public static int update(String query){
		return updateAndDelete(query);
	}
	
	// Logic to update or delete row
	private static int updateAndDelete(String query) {
		Connection connection = connect();
		
		int rows = 0;
		
		try{
			java.sql.PreparedStatement stmt = connection.prepareStatement(query);
			rows = stmt.executeUpdate();
			
			return rows;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect(connection);
		
		return rows;
	}
	
	// select query stuff
	public static ResultSet retrieve (String query) {
		Connection connection = connect();
		
		ResultSet rset = null;
		
		try {
			Statement stmt = connection.createStatement();
			rset = stmt.executeQuery(query);
			
			return rset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect(connection);
		
		return rset;
	}
	
	public static void disconnect(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
