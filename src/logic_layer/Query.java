package logic_layer;

import data_access_layer.DbAccess;
import domain_layer.Book;
import domain_layer.Cart;
import domain_layer.CreditCard;
import domain_layer.Customer;
import domain_layer.Order;
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
	
	public static Book getBookByIsbn(String isbn) throws SQLException {
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
				book.getIsbn() + "', '" +
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
		
		System.out.println(query);
			
		return DbAccess.insert(query) == 1;
	}
	
	public static boolean updateInventory(Book book) {
		String query = "UPDATE book SET " +
				"isbn ='" + book.getIsbn() + "', " +
				"title ='" + book.getTitle() + "', " +
				"author ='" + book.getAuthor() + "', " +
				"price ='" + book.getPrice() + "', " +
				"genre ='" + book.getGenre() + "', " +
				"publisher ='" + book.getPublisher() + "', " +
				"vendor ='" + book.getVendor() + "', " +
				"stock ='" + book.getStock() + "', " +
				"promocode ='" + book.getPromoCode() + "', " +
				"promoprice ='" + book.getPromoPrice() + "', " +
				"hold ='" + book.getHold() + "', " +
				"image ='" + book.getImage() + "', " +
				"description ='" + book.getDescription() + "' " +
				"WHERE isbn ='" + book.getIsbn() + "'";
		
		System.out.println(query);
			
		return DbAccess.update(query) == 1;
	}
	
	public static boolean deleteItem(String isbn) {
		String query = "DELETE FROM book WHERE isbn ='" + isbn + "'";
		
		return DbAccess.delete(query) == 1;
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
	
	public static ArrayList<Book> getBooksByGenre(String genre) throws SQLException {
		String query = "select * from book where genre ='" + 
				genre + "'";
		
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
	
	public static ArrayList<Book> getBooksByTitle(String title) throws SQLException {
		String query = "select * from book where title ='" + 
				title + "'";
		
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
	
	public static ArrayList<Book> getBooksByAuthor(String author) throws SQLException {
		String query = "select * from book where author ='" + 
				author + "'";
		
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
	
	public static ArrayList<Book> getBooksByIsbn(String isbn) throws SQLException {
		String query = "select * from book where  ='" + 
				isbn + "'";
		
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
	
	public static ArrayList<Customer> getAllUsers() throws SQLException {
		String userQuery = "SELECT * FROM user";
		
		ArrayList<Customer> retList = new ArrayList<>();
		ResultSet userSet = DbAccess.retrieve(userQuery);
		
		while(userSet.next()) {
			Customer customer = QueryUtil.resultSetsToCustomer(userSet);
			if (customer != null) {
				retList.add(customer);
			}
		}
		
		return retList;
	}
	
	public static boolean addCustomer(Customer customer) {
		String query = "INSERT into user "
				+ "(email, password, first_name, last_name, shipping_address, billing_address, permission, subscription, shipping_street, shipping_city, shipping_state, shipping_zip, billing_street, billing_city, billing_state, billing_zip) " + 
				"Values('" +
				customer.getEmail() + "', '" +
				customer.getPassword() + "', '" +
				customer.getFirstName() + "', '" +
				customer.getLastName() + "', '" +
				customer.getShippingAddress() + "', '" +
				customer.getBillingAddress() + "', '" +
				customer.getPermission() + "', '" +
				customer.getSubscription() + "', '" +
				customer.getStreetShipping() + "', '" +
				customer.getCityShipping() + "', '" +
				customer.getStateShipping() + "', '" +
				customer.getZipShipping() + "', '" +
				customer.getStreetBilling() + "', '" +
				customer.getCityBilling() + "', '" +
				customer.getStateBilling() + "', '" +
				customer.getZipBilling() + "')";
		
		System.out.println(query);
		
		return DbAccess.insert(query) == 1;
	}
	
	public static boolean updateCustomer(Customer customer) {
		String query = "UPDATE user SET " +
				"email ='" + customer.getEmail() + "', " +
				"password ='" + customer.getPassword() + "', " +
				"first_name ='" + customer.getFirstName() + "', " +
				"last_name ='" + customer.getLastName() + "', " +
				"shipping_address ='" + customer.getShippingAddress() + "', " +
				"billing_address ='" + customer.getBillingAddress() + "', " +
				"permission ='" + customer.getPermission() + "', " +
				"subscription ='" + customer.getSubscription() + "', " +
				"shipping_street ='" + customer.getStreetShipping() + "', " +
				"shipping_city ='" + customer.getCityShipping() + "', " +
				"shipping_state ='" + customer.getStateShipping() + "', " +
				"shipping_zip ='" + customer.getZipShipping() + "', " +
				"billing_street ='" + customer.getStreetBilling() + "', " +
				"billing_city ='" + customer.getCityBilling() + "', " +
				"billing_state ='" + customer.getStateBilling() + "', " +
				"billing_zip ='" + customer.getZipBilling() + "' " +
				"WHERE email ='" + customer.getEmail() + "'";
		
		return DbAccess.insert(query) == 1;
	}
	
	public static boolean deleteUser(String email) {
		String query = "DELETE FROM user WHERE email ='" + email + "'";
		
		return DbAccess.delete(query) == 1;
	}
	
	public static Customer getUserByEmail(String email) throws SQLException {
		String query = "SELECT * FROM user WHERE email ='" 
				+ email + "'";
		
		ResultSet resultSet = DbAccess.retrieve(query);
		resultSet.next();

		Customer user = QueryUtil.resultSetsToCustomer(resultSet);

		return user;
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
					book.getIsbn() + "', '" + 
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
	
	
	public static boolean setHold(Cart book, int hold) {
		String query = "UPDATE book set hold ='" + hold + "' where isbn ='" + book.getIsbn() + "'"; 
		
		System.out.println(query);
		
		return DbAccess.update(query) == 1; 
	}
	
	public static boolean updateBookStock(Book book, int stock) {
		String query = "UPDATE book set stock ='" + stock + "' where isbn ='" + book.getIsbn() + "'"; 
		
		return DbAccess.update(query) == 1; 
	}
	
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
				System.out.println(cart.getIsbn());
				retList.add(cart);
			}
		}
		
		return retList;
	}
	
	public static boolean setCartQuantity(String email, Book book, int qty) {
		String query = "UPDATE cart SET quantity ='" + qty + 
				"' WHERE email ='" + email +
				"' and isbn ='" + book.getIsbn() + "'";
		System.out.println(query);
		return DbAccess.insert(query) == 1;
	}
	
	public static boolean deleteBookFromCart(String email, Book book) {
		String query = "DELETE FROM cart WHERE email ='" + email +
				"' and isbn ='" + book.getIsbn() + "'";
		
		return DbAccess.insert(query) == 1;
	}
	
	public static boolean deleteCart(String email) {
		String query = "DELETE FROM cart WHERE email ='" + email + "'";
		
		return DbAccess.delete(query) == 1;
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
	
	public static Customer getCustomerInfo(String email) throws SQLException {
		String userQuery = "select * from user where email = '" + email + "'";
		String creditCardInfo = "select * from credit_card where email ='" + email + "'";
		
		ResultSet user = DbAccess.retrieve(userQuery);
		ResultSet creditCard = DbAccess.retrieve(creditCardInfo);
		
		return QueryUtil.resultSetsToCustomer(user, creditCard);
	}
	
	public static CreditCard getCreditCardInfo(String email) throws SQLException {
		String query = "select * from credit_card where email = '" + email + "'";
		
		ResultSet card = DbAccess.retrieve(query);
		
		return QueryUtil.resultSetToCreditCard(card);
	}
	
	public static boolean addPickupOrder(Order order) {
		double total = Double.parseDouble(String.format("%.2f", order.getTotal()));
		double subTotal = Double.parseDouble(String.format("%.2f", order.getSubTotal()));
		double tax = Double.parseDouble(String.format("%.2f", order.getTax()));
		double shippingCost = Double.parseDouble(String.format("%.2f", order.getShippingCost()));
		
		String query = "INSERT into order " + 
				"(email, date, total, subtotal, tax, shipping_cost, shipping_address, payment_card, billing_address, status) " + 
				"VALUES ('" +
				order.getEmail() + "', '" +
				order.getDate() + "', '" +
				total + "', '" + 
				subTotal + "', '" +
				tax + "', '" +
				shippingCost + "', '" +
				order.getShippingAddress() + 
				"', 'pickup', '" +
				order.getBillingAddress() + "', '" +
				order.getStatus() + "')";
		
		System.out.println(query);
			
		return DbAccess.insert(query) == 1;
	}
	
	public static boolean addCardOrder(Order order) {
		String total = String.format("%.2f", order.getTotal());
		String subTotal = String.format("%.2f", order.getSubTotal());
		String tax = String.format("%.2f", order.getTax());
		String shippingCost = String.format("%.2f", order.getShippingCost());
		
		String query = "insert into `order` " + 
				"(email, date, total, subtotal, tax, shipping_cost, shipping_address, payment_card, billing_address, status) " + 
				"Values('" +
				order.getEmail() + "', '" +
				order.getDate() + "', '" +
				total + "', '" + 
				subTotal + "', '" +
				tax + "', '" +
				shippingCost + "', '" +
				order.getShippingAddress() + "', '" +
				order.getPaymentCard() + "', '" +
				order.getBillingAddress() + "', '" +
				order.getStatus() + "')";
		
		System.out.println(query);
			
		return DbAccess.insert(query) == 1;
	}
	
	public static ArrayList<Order> getAllOrders() throws SQLException {
		String query = "select * from `order`";
		
		System.out.println(query);
		ArrayList<Order> retList = new ArrayList<>();
		ResultSet resultSet = DbAccess.retrieve(query);
		
		while(resultSet.next()) {
			Order order = QueryUtil.resultSetToOrder(resultSet);
			if (order != null) {
				retList.add(order);
			}
		}
		
		return retList;
	}
	
	public static boolean updateOrderStatus(String email, String date, String total, String status) {
		String query = "UPDATE `order` SET " +
				"status ='" + status + "', " +
				"WHERE email='" + email + 
				"' and date ='" + date + 
				"' and total ='" + total + "'";
		
		System.out.println(query);
			
		return DbAccess.update(query) == 1;
	}
}
