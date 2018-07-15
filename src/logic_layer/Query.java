package logic_layer;

import data_access_layer.DbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class Query {
	
	private static DbAccess database = new DbAccess();
	
	/*
	 * This method is called from the Login_Servlet, and it creates a query to that is executed to enter a new user into the database.
	 */
	public static int insertNewUser(HttpServletRequest request, HttpServletResponse response, String name, String email, String password) {
		// TODO Update Not Correct
		String query = "INSERT INTO users (name, email, password) Values('"+name+"', '"+email+"', '"+password+"')";
		int r = 0;
		
		return database.insert(query);
	}
	
	/**
	 * Method checks if the email already exists in the system
	 * @return true is the email exists else false.
	 * @throws SQLException 
	 */
	public static boolean emailExists(String email) throws SQLException {
		String query = "SELECT * FROM customer WHERE email =\'" + email + "\'";
		
		return database.retrieve(query).next();
	}
}
