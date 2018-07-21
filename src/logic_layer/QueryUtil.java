package logic_layer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import domain_layer.Book;
import domain_layer.Cart;
import domain_layer.Customer;

public class QueryUtil {
	
	/**
	 * Method will take in a resultSet from Book DB
	 * and set result values to Book object
	 * @param result: ResultSet of Books
	 * @return null if resultSet Not from book else Book
	 * object with ResultSet data.
	 * @throws SQLException 
	 */
	protected static Book resultSetToBook(ResultSet result) throws SQLException {
		ResultSetMetaData rsmd = result.getMetaData();

		if (rsmd.getColumnCount() != 13) {
			return null;
		}
		
		Book book = new Book();
		book.setIsbn(result.getString("isbn"));
		book.setTitle(result.getString("title"));
		book.setAuthor(result.getString("author"));
		book.setPrice(result.getDouble("price"));
		book.setGenre(result.getString("genre"));
		book.setPublisher(result.getString("publisher"));
		book.setVendor(result.getString("vendor"));
		book.setStock(result.getInt("stock"));
		book.setPromoCode(result.getString("promocode"));
		book.setPromoPrice(result.getDouble("promoprice"));
		book.setHold(result.getInt("hold"));
		book.setImage(result.getString("image"));
		book.setDescription(result.getString("description"));
		
		return book;
	}
	protected static Cart resultSetToCart(ResultSet result) throws SQLException {
		ResultSetMetaData rsmd = result.getMetaData();

		if (rsmd.getColumnCount() != 10) {
			System.out.println("null pointer error is a coming!");
			return null;
		}
		
		Cart cart = new Cart();
		cart.setEmail(result.getString("email"));
		cart.setISBN(result.getString("isbn"));
		cart.setTitle(result.getString("title"));
		cart.setAuthor(result.getString("author"));
		cart.setPrice(result.getDouble("price"));
		cart.setPublisher(result.getString("publisher"));
		cart.setImage(result.getString("image"));
		cart.setQty(result.getInt("quantity"));

		return cart;
	}
	
	protected static Customer resultSetsToCustomer(ResultSet user, ResultSet creditCard) throws SQLException {
		if (!user.next() || !creditCard.next()) {
			return null;
		}
		
		Customer customer = new Customer();
		
		customer.setEmail(user.getString("email"));
		customer.setPassword(user.getString("password"));
		customer.setFirstName(user.getString("first_name"));
		customer.setLastName(user.getString("last_name"));
		customer.setShippingAddress(user.getString("shipping_address"));
		customer.setBillingAddress(user.getString("billing_address"));
		customer.setCcNumber(creditCard.getString("number"));
		customer.setSecurityCode(creditCard.getString("security_code"));
		customer.setCcExpiration(creditCard.getString("expiration_date"));
		
		return customer;
	}
}
