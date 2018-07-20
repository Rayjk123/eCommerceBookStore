package logic_layer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import domain_layer.Book;

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
		System.out.println("Test3");
		if (rsmd.getColumnCount() != 13) {
			System.out.println("Test4");
			return null;
		}
		System.out.println("Test5");
		Book book = new Book();
		System.out.println("Test6");
		book.setISBN(result.getString("isbn"));
		System.out.println("Test6.1");
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
		System.out.println("Test7");
		
		return book;
	}
}
