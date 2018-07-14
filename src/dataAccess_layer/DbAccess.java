package dataAccess_layer;
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
	
	public static Connection connect() {
		Connection con = null;
		
		try {
			Class.forName(DRIVE_NAME);
			String jdbcUrl = "jdbc:mysql://" + HOST_NAME + ":" + "3306" + "/" + "bookStore" + "?user=" + "root" + "&password=" + "emanSaleh17";
		    con = DriverManager.getConnection(jdbcUrl);
			
			System.out.println("Established a connection.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//If rows = 0 after the code is ran, that means 0 rows were updated.
	public static int insert (String query){
		int rows = 0;
		
		try {
			Connection con = connect();
			java.sql.PreparedStatement stmt = con.prepareStatement(query);
			rows = stmt.executeUpdate();
			disconnect(con);
			
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	public static int delete(String query){
		return updateOrDelete(query);
	}
	
	public static int update(String query){
		return updateOrDelete(query);
	}
	
	// Logic to update or delete row
	private static int updateOrDelete(String query) {
		int rows=0;
		
		try{
			Connection con = connect();
			java.sql.PreparedStatement stmt = con.prepareStatement(query);
			rows=stmt.executeUpdate();
			disconnect(con);
			
			return rows;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}
	
	// select query stuff
	public static ResultSet retrieve (Connection con, String query) {
		ResultSet rset = null;
		
		try {
			Statement stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			return rset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rset;
	}
	
	public static void disconnect(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
