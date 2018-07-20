package boundary;

import java.io.IOException;
import java.sql.SQLException;

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
		
		try {
			addToCart(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void addToCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email"); //TODO need create a customer object at login and setAttribute
		String isbn = request.getParameter("isbn");
		int quantity = Integer.parseInt(request.getParameter("qty")); //quantity the user wants to add to cart 
																		//TODO need a default quantity of 1 in bookDetail.html
																		//TODO edit cart will have a field to set quantity in cart
		Book book = Query.getBookByISBN(isbn);
		
		//can't add more than what's in stock to cart
		if (book.getStock() - quantity > 0) {
			Query.addToCart(email, isbn, quantity); 
		}
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/index.html"); //TODO make Cart.jsp
		dispatcher.forward(request, response); 
	}
}
