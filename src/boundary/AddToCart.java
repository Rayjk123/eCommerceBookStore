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
import domain_layer.Customer;

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
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/bookDetail.jsp"); //TODO what actually should be here?
		dispatcher.forward(request, response); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void addToCart(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer"); //TODO need create a customer object at login and setAttribute
		Book book = new Book(request.getParameter("isbn"));
		
		book.setStock(Integer.parseInt(request.getParameter("stock")));
		int quantity = Integer.parseInt(request.getParameter("quantity")); //quantity the user wants to add to cart 
																		//TODO need a default quantity of 1 in bookDetail.html
																		//TODO edit cart will have a field to set quantity in cart
		//can't add more than what's in stock to cart
		if (book.getStock() - quantity > 0) {
			Query.addToCart(customer, book, quantity); 
		}
	}
}
