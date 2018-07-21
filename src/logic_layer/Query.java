package logic_layer;

import data_access_layer.DbAccess;
import domain_layer.Book;
import domain_layer.Customer;
import domain_layer.Cart;
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
	
	public static Book getBookByISBN(String isbn) throws SQLException {
		String query = "SELECT * FROM book WHERE isbn ='" 
				+ isbn + "'";
		
		ResultSet resultSet = DbAccess.retrieve(query);
		resultSet.next();

		Book book = QueryUtil.resultSetToBook(resultSet);

		return book;
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
			if (book != null) {
				retList.add(book);
			}
		}
		
		return retList;
	}
	
	/**
	 * method adds an entry to cart database
	 * @param customer
	 * @param book
	 * @param quantity
	 * @return true if inserted with no error
	 */
	public static boolean addToCart(String email, Book book, int quantity) {
		String query = "INSERT INTO cart " 
				+ "(email, isbn, quantity, title, author, publisher, price, stock, hold, image) "
				+ "Values('" + 
					email + "', '" +
					book.getISBN() + "', '" + 
					quantity + "', '" +
					book.getTitle() + "', '" + 
					book.getAuthor() + "', '" + 
					book.getPublisher() + "', '" +
					book.getPrice() + "', '" +
					book.getStock() + "', '" +
					book.getHold() + "', '" + 
					book.getImage() + "')";
		
		return DbAccess.insert(query) == 1;
	}
	
	/* hold book for pickup, hold is a value in the book table
	public static boolean holdBook(Book book) {
		int hold = book.getHold(); 
				
		String query = "UPDATE book " 
				+ "set hold = "  + " where isbn " + book.getISBN(); 
		
		return database.update(query) == 1; 
	}*/
	public static ArrayList<Cart> getBooksInCart(String email) throws SQLException {
		String query = "SELECT * FROM cart WHERE email ='"
				+ email + "'";
		
		System.out.println(query);
		
		ArrayList<Cart> retList = new ArrayList<>();
		ResultSet cartResultSet = DbAccess.retrieve(query);
		
		while(cartResultSet.next()) {
			Cart cart = QueryUtil.resultSetToCart(cartResultSet);
			System.out.println(cart.getAuthor());
			if (cart != null) {
				System.out.println(cart.getISBN());
				retList.add(cart);
			}
		}
		
		return retList;
	}
	
	public static boolean setCartQuantity(String email, String isbn, int qty) {
		String query = "UPDATE cart SET quantity ='" + qty + 
				"' WHERE email ='" + email +
				"' and isbn='" + isbn;
		
		return DbAccess.insert(query) == 1;
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
		String query = "SELECT * FROM user WHERE email ='" + email + "' AND password = '" + password + "'";
		
		return DbAccess.retrieve(query).next();
	}
	
	public static String getPermission(String email) throws SQLException {
		String query = "SELECT permission FROM user WHERE email ='" + email + "'";
		ResultSet rs = DbAccess.retrieve(query);
		rs.next();
		return rs.getString("permission");
	}
	
	public static boolean insertCreditCard(String email, String number, String securityCode, String expiration) {
		String query = "INSERT INTO credit_card (email, number, security_code, expiration_date) "
				+ "VALUES ('" + email + "', '" + number + "', '" + securityCode + "', '" + expiration + "')";
		
		return DbAccess.insert(query) == 1;
	}
	
//	public static Customer getCustomerInfo() {
//		
//	}
}
