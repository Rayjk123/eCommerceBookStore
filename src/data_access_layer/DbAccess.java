package data_access_layer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbAccess {
	
	static final String DRIVE_NAME = "com.mysql.jdbc.Driver";
		
	static final String HOST_NAME = "bookstoredb.cxutrsepuguc.us-east-2.rds.amazonaws.com";
	
	static final String DB_CONNECTION_USERNAME = "csci4050";
	
	static final String DB_CONNECTION_PASSWORD = "csci4050uga";
	
	Connection connection;
	
	public DbAccess() {
		try {
			Class.forName(DRIVE_NAME);
			String jdbcUrl = "jdbc:mysql://" + HOST_NAME + ":" + "3306" + "/" + "bookStore" + "?user=" + "root" + "&password=" + "emanSaleh17";
		    connection = DriverManager.getConnection(jdbcUrl);
			
			System.out.println("Established a connection.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect() {
		try {
			Class.forName(DRIVE_NAME);
			String jdbcUrl = "jdbc:mysql://" + HOST_NAME + ":" + "3306" + "/" + "bookStore" + "?user=" + "root" + "&password=" + "emanSaleh17";
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
	public int insert (String query){
		int rows = 0;
		
		try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(query);
			rows = stmt.executeUpdate();
			
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public int delete(String query){
		return updateAndDelete(query);
	}
	
	public int update(String query){
		return updateAndDelete(query);
	}
	
	// Logic to update or delete row
	private int updateAndDelete(String query) {
		int rows = 0;
		
		try{
			java.sql.PreparedStatement stmt = connection.prepareStatement(query);
			rows = stmt.executeUpdate();
			
			return rows;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	// select query stuff
	public ResultSet retrieve (String query) {
		ResultSet rset = null;
		
		try {
			Statement stmt = connection.createStatement();
			rset = stmt.executeQuery(query);
			
			return rset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rset;
	}
	
	public void disconnect() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
