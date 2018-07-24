package logic_layer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import domain_layer.Book;
import domain_layer.Cart;
import domain_layer.CreditCard;
import domain_layer.Customer;
import domain_layer.Order;

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
			return null;
		}
		
		Cart cart = new Cart();
		cart.setEmail(result.getString("email"));
		cart.setIsbn(result.getString("isbn"));
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
		customer.setPermission(user.getString("permission"));
		customer.setSubscripion(user.getString("subscription"));
		customer.setStreetShipping(user.getString("shipping_street"));
		customer.setCityShipping(user.getString("shipping_city"));
		customer.setStateShipping(user.getString("shipping_state"));
		customer.setZipShipping(user.getString("shipping_zip"));
		customer.setStreetBilling(user.getString("billing_street"));
		customer.setCityBilling(user.getString("billing_city"));
		customer.setStateBilling(user.getString("billing_state"));
		customer.setZipBilling(user.getString("billing_zip"));
		
		return customer;
	}
	
	//OVERLOADED method
	protected static Customer resultSetsToCustomer(ResultSet user) throws SQLException {
		ResultSetMetaData rsmd = user.getMetaData();

		if (rsmd.getColumnCount() != 16) {
			return null;
		}
		
		Customer customer = new Customer();
		
		customer.setEmail(user.getString("email"));
		customer.setPassword(user.getString("password"));
		customer.setFirstName(user.getString("first_name"));
		customer.setLastName(user.getString("last_name"));
		customer.setShippingAddress(user.getString("shipping_address"));
		customer.setBillingAddress(user.getString("billing_address"));
		customer.setPermission(user.getString("permission"));
		customer.setSubscripion(user.getString("subscription"));
		customer.setStreetShipping(user.getString("shipping_street"));
		customer.setCityShipping(user.getString("shipping_city"));
		customer.setStateShipping(user.getString("shipping_state"));
		customer.setZipShipping(user.getString("shipping_zip"));
		customer.setStreetBilling(user.getString("billing_street"));
		customer.setCityBilling(user.getString("billing_city"));
		customer.setStateBilling(user.getString("billing_state"));
		customer.setZipBilling(user.getString("billing_zip"));
		
		return customer;
	}
	
	protected static CreditCard resultSetToCreditCard(ResultSet resultSet) throws SQLException {
		ResultSetMetaData rsmd = resultSet.getMetaData();

		if (rsmd.getColumnCount() != 6) {
			return null;
		}
		
		resultSet.next();
		
		CreditCard card = new CreditCard();
		
		card.setCardNumber(resultSet.getString("number"));
		card.setCardExpiration(resultSet.getString("expiration_date"));
		card.setCardSecurityCode(resultSet.getString("security_code"));
		card.setExpirationMonth(resultSet.getString("expiration_month"));
		card.setExpirationYear(resultSet.getString("expiration_year"));
		
		return card;
	}
	
	protected static String userResultSetToEmail(ResultSet user) throws SQLException {
		if (!user.next()) {
			return null;
		}
		
		String email = user.getString("email");
		
		return email;
	}
	
	protected static Order resultSetToOrder(ResultSet resultSet) throws SQLException {
		ResultSetMetaData rsmd = resultSet.getMetaData();

		if (rsmd.getColumnCount() != 11) {
			return null;
		}
		
		Order order = new Order();
		
		order.setBillingAddress(resultSet.getString("billing_address"));
		order.setDate(resultSet.getString("date"));
		order.setEmail(resultSet.getString("email"));
		order.setPaymentCard(resultSet.getString("payment_card"));
		order.setShippingAddress(resultSet.getString("shipping_address"));
		order.setStatus(resultSet.getString("status"));
		order.setSubTotal(Double.parseDouble(resultSet.getString("subtotal")));
		order.setTax(Double.parseDouble(resultSet.getString("tax")));
		order.setShippingCost(Double.parseDouble(resultSet.getString("shipping_cost")));
		order.setTotal(Double.parseDouble(resultSet.getString("total")));
		order.setOrderNumber(Integer.parseInt(resultSet.getString("id")));
		
		return order;
	}
}
