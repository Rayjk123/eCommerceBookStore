package boundary;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;

import logic_layer.Query;
import domain_layer.Book;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/GetBookServlet")
public class GetBookServlet extends HttpServlet {

	/**
     * @see HttpServlet#HttpServlet()
     */
	public GetBookServlet(){
		super(); //HttpServlet constructor
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String isbn = request.getParameter("isbn");
		String isbn = "9781782274209";
		try {
			getBook(request, response, isbn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/bookDetail.jsp"); //TODO what actually should be here?
		dispatcher.forward(request, response); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void getBook(HttpServletRequest request, HttpServletResponse response, String isbn) throws SQLException {
		//Book book = new Book(request.getParameter("isbn")); // TODO need to pass isbn from browse to book detail views
		Book book = new Book();
		//isbn = "9781782274209";
		
		List<Book> list = new ArrayList<>();
		ResultSet rs = Query.getBookByIsbn(isbn); //results in only one book
		
		book.setISBN(isbn);
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setPrice(rs.getDouble("price"));
		book.setGenre(rs.getString("genre"));
		book.setPublisher(rs.getString("publisher"));
		book.setVendor(rs.getString("vendor"));
		book.setStock(rs.getInt("stock"));
		book.setPromoCode(rs.getString("promocode"));
		book.setPromoPrice(rs.getDouble("promoprice"));
		book.setHold(rs.getInt("hold"));
		book.setImage(rs.getString("image"));
		book.setDescription(rs.getString("description"));
		
		list.add(book);
		
		request.setAttribute("results", list);
	}
}
