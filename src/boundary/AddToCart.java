package boundary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

import logic_layer.Query;
import domain_layer.Book;

@SuppressWarnings("serial")
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {

	/**
     * @see HttpServlet#HttpServlet()
     */
	public AddToCart(){
		super(); //HttpServlet constructor
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		int qty = Integer.parseInt(request.getParameter("qty"));
		
		try {
			addToCart(request, response, isbn, qty);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void addToCart(HttpServletRequest request, HttpServletResponse response, String isbn, int qty) throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email"); //TODO need create a customer object at login and setAttribute
		email = "test@domain.com";
		RequestDispatcher dispatcher;
		
		if (email == null)
		{
			dispatcher = request.getRequestDispatcher("/login.html");
			dispatcher.forward(request, response);
			/*
			 * TODO allow carts with session ID
			 */
		}
		
		Book book = Query.getBookByISBN(isbn);
		
		//can't add more than what's in stock to cart
		if (book.getStock() - qty > 0) {
			Query.addToCart(email, isbn, qty); 
		}
		else
		{
			Query.addToCart(email, isbn, book.getStock());
		}
		
		ArrayList<Book> books = Query.getBooksInCart(email);
		request.setAttribute("books", books);
		dispatcher = request.getRequestDispatcher("/Cart.jsp"); 
		dispatcher.forward(request, response); 
	}
}
