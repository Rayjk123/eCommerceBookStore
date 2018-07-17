package logic_layer;

import data_access_layer.DbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import domain_layer.Book;
import domain_layer.Customer;

public class Query {
	
	private static DbAccess database = new DbAccess();
	
	public static boolean insertNewUser(String email, String password, String firstName, String lastName, String permission) {
		// TODO Update Not Correct
		String query = "INSERT INTO user "
				+ "(email, password, first_name, last_name, permissions) "
				+ "Values('"+ email +"', '"+ password +"', '"+ firstName +"', '"+ lastName + "', '" + permission + "')";
		
		return database.insert(query) == 1;
	}
	
	public static boolean addToCart(String accountID, String isbn) {
		//Cart database is association between Customer and Book database
		String query = "INSERT INTO cart " 
				+ "(accountID, isbn) "
				+ "Values('" + accountID + "', '" + isbn + "')";
		
		return database.insert(query) == 1;
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
