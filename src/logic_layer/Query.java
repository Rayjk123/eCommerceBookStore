package logic_layer;

import data_access_layer.DbAccess;
import domain_layer.Book;
import domain_layer.Customer;
import logic_layer.QueryUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class Query {
	
	public Query() {
		
	}
	
	public static boolean insertNewUser(String email, String password, 
			String firstName, String lastName, String permission,
			String shippingAddress, String billingAddress) {
		// TODO Update Not Correct
		String query = "INSERT INTO user "
				+ "(email, password, first_name, last_name, permission, shipping_address, billing_address) "
				+ "Values('"+ email +"', '"+ password +"', '"+ firstName +"', '"+ lastName + "', '" + permission 
				+ "', '" + shippingAddress + "', '" + billingAddress + "')";
		
		return DbAccess.insert(query) == 1;
	}
	/**c
	 * method adds an entry to cart database
	 * @param customer
	 * @param book
	 * @param quantity
	 * @return true if inserted with no error
	 */
	public static boolean addToCart(Customer customer, Book book, int quantity) {
		String query = "INSERT INTO cart " 
				+ "(email, isbn, quantity) "
				+ "Values('" + customer.getEmail() + "', '" 
				+ book.getISBN() + "', '" 
				+ quantity + "')";
		
		return DbAccess.insert(query) == 1;
	}
	
	/* hold book for pickup, hold is a value in the book table
	public static boolean holdBook(Book book) {
		int hold = book.getHold(); 
				
		String query = "UPDATE book " 
				+ "set hold = "  + " where isbn " + book.getISBN(); 
		
		return database.update(query) == 1; 
	}*/
	
	public static ResultSet getBookByIsbn(String isbn) {
		String query = "SELECT * FROM book WHERE isbn = '"
				+ isbn + "'";
		
		return DbAccess.retrieve(query);
	}
	
	public static boolean addBookToInventory(Book book) {
		String query = "INSERT into book "
				+ "(isbn, title, author, price, genre, publisher, vendor, stock, promocode, promoprice, hold, image, description) " + 
				"Values('" +
				book.getISBN() + "', '" +
				book.getTitle() + "', '" +
				book.getAuthor() + "', '" +
				book.getPrice() + "', '" +
				book.getGenre() + "', '" +
				book.getPublisher() + "', '" +
				book.getVendor() + "', '" +
				book.getStock() + "', '" +
				book.getPromoCode() + "', '" +
				book.getPromoPrice() + "', '" +
				book.getHold() + "', '" +
				book.getImage() + "', '" +
				book.getDescription() + "')";
			
		return DbAccess.insert(query) == 1;
	}
	
	public static ArrayList<Book> getAllBooks() throws SQLException {
		String query = "select * from book";
		
		ArrayList<Book> retList = new ArrayList<>();
		ResultSet resultSet = DbAccess.retrieve(query);
		
		
		while(resultSet.next()) {
			Book book = QueryUtil.resultSetToBook(resultSet);
			System.out.println(book);
			
			if (book != null) {
				retList.add(book);
			}
		}
		
		return retList;
	}
	
	/**
	 * Method checks if the email already exists in the system
	 * @return true is the email exists else false.
	 * @throws SQLException 
	 */
	public static boolean emailExists(String email) throws SQLException {
		String query = "SELECT * FROM user WHERE email ='" + email + "'";
		
		return DbAccess.retrieve(query).next();
	}
	
	public static boolean confirmationCodeValid(String confirmationCode) throws SQLException {
		String query = "SELECT * FROM confirmation WHERE confirmation_code =\'" + confirmationCode + "\'";
		
		return DbAccess.retrieve(query).next();
	}
	
	public static boolean addConfirmationCode(String email, String confirmationCode) {
		String query = "INSERT INTO confirmation (email, confirmation_code) VALUES ('"
				+ email + "', '"
				+ confirmationCode + "')";
		
		return DbAccess.insert(query) == 1;
	}
	
	public static boolean validateLogin(String email, String password) throws SQLException {
		String query = "SELECT * FROM user WHERE email ='" + email + "', ' AND password = '" + password + "'";
		
		return DbAccess.retrieve(query).next();
	}
	
	public static String getPermission(String email) throws SQLException {
		String query = "SELECT permission FROM user WHERE email ='" + email + "'";
		ResultSet rs = DbAccess.retrieve(query);
		rs.next();
		return rs.getString("permission");
	}
}
