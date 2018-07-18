package logic_layer;

import data_access_layer.DbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.sql.ResultSet;

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
	/**
	 * method adds an entry to cart database
	 * @param customer, accountID
	 * @param book, isbn
	 * @param quantity, number of same book in cart
	 * @return
	 */
	public static boolean addToCart(Customer customer, Book book, int quantity) {
		String query = "INSERT INTO cart " 
				+ "(accountID, isbn, quantity) "
				+ "Values('" + customer.getAccountID() + "', '" 
				+ book.getISBN() + "', '" 
				+ quantity + "')";
		
		return database.insert(query) == 1;
	}
	
	/* hold book for pickup, hold is a value in the book table
	public static boolean holdBook(Book book) {
		int hold = book.getHold(); 
				
		String query = "UPDATE book " 
				+ "set hold = "  + " where isbn " + book.getISBN(); 
		
		return database.update(query) == 1; 
	}*/
	
	public ResultSet getBook(int isbn) {
		String query = "Select * from book WHERE isbn = '"
				+ isbn + "'";
		
		return database.retrieve(query);
	}
	
	public static boolean addBookToInventory(Book book) {
		String query = "INSERT into book "
				+ "(isbn, price, title, author, genre, publisher, vendor, stock, promocode, promoprice, holdqty, image, description) " + 
				"Values('" +
				book.getISBN() + "', '" +
				book.getPrice() + "', '" +
				book.getTitle() + "', '" +
				book.getAuthor() + "', '" +
				book.getGenre() + "', '" +
				book.getPublisher() + "', '" +
				book.getVendor() + "', '" +
				book.getStock() + "', '" +
				book.getPromoCode() + "', '" +
				book.getPromoPrice() + "', '" +
				book.getHold() + "', '" +
				book.getImage() + "', '" +
				book.getDescription() + "')";
			
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
