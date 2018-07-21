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
import domain_layer.Cart;

@SuppressWarnings("serial")
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

	/**
     * @see HttpServlet#HttpServlet()
     */
	public CartServlet(){
		super(); //HttpServlet constructor
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String isbn = request.getParameter("isbn");
		int qty = Integer.parseInt(request.getParameter("qty"));
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email"); 

		// TODO allow login refers back to Cart
		if (email == null)
		{
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/login.html");
			dispatcher.forward(request, response);
		}
		
		System.out.println("EMAIL = " + email);
		System.out.println("QTY = " + request.getParameter("qty"));
		System.out.println("ACTION = " + action);
		System.out.println("ISBN = " + isbn);
		
		servletHelper(request, response, action, email, isbn, qty);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void servletHelper(HttpServletRequest request, HttpServletResponse response, String action, String email, String isbn, int qty) {
		if (action.equals("add")) {
			System.out.println("action = " + action);
			try {
				addToCart(request, response, email, isbn, qty);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (action.equals("edit"))
		{
			try {
				changeQuantity(request, response, email, isbn, qty);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("action = " + action);
		}
		else if (action.equals("delete"))
		{
			// TODO replace with change quantity method
			System.out.println("action = " + action);
		}
		else 
		{
			// TODO only print cart function
			System.out.println("action = " + action);
			System.out.println("Default to cart view");
		}
	}
	
	private void addToCart(HttpServletRequest request, HttpServletResponse response, String email, String isbn, int qty) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher;
		System.out.println("add to cart");
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
			Query.addToCart(email, book, qty); 
		}
		else
		{
			Query.addToCart(email, book, book.getStock());
		}
		
		ArrayList<Cart> books = Query.getBooksInCart(email);
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i).getTitle());
		}
		request.setAttribute("books", books);
		
		double cartTotal = 0.00;
		for (int i=0; i < books.size(); i++) {
			cartTotal = cartTotal + books.get(i).getPrice() * books.get(i).getQty();
		}
		request.setAttribute("total", cartTotal);
		dispatcher = request.getRequestDispatcher("/Cart.jsp"); 
		dispatcher.forward(request, response); 
	}

	private void changeQuantity(HttpServletRequest request, HttpServletResponse response, String email, String isbn, int qty) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher;
		System.out.println("change quantity");
		Book book = Query.getBookByISBN(isbn);
		
		//can't add more than what's in stock to cart
		if (book.getStock() - qty > 0) {
			Query.setCartQuantity(email, isbn, qty); 
		}
		else
		{
			Query.setCartQuantity(email, isbn, book.getStock());
		}
		
		ArrayList<Cart> books = Query.getBooksInCart(email);
		request.setAttribute("books", books);
		
		
		double cartTotal = 0.00;
		for (int i=0; i < books.size(); i++) {
			cartTotal = cartTotal + books.get(i).getPrice() * books.get(i).getQty();
		}
		request.setAttribute("total", cartTotal);
		dispatcher = request.getRequestDispatcher("/Cart.jsp"); 
		dispatcher.forward(request, response); 
		System.out.println("add to cart end");
	}
	
	private double getCartTotal(ArrayList<Cart> cart) {
		double total=0.00;
		
		return total;
	}
}
