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
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email"); 

		// TODO allow login refers back to Cart
		if (email == null)
		{
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/login.html");
			dispatcher.forward(request, response);
		}
		
		servletHelper(request, response, email);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void servletHelper(HttpServletRequest request, HttpServletResponse response, String email) {
		if (request.getParameter("action") != null & request.getParameter("isbn") != null & request.getParameter("qty") != null) {
			String action = request.getParameter("action");
			String isbn = request.getParameter("isbn");
			int qty = Integer.parseInt(request.getParameter("qty"));
			
			System.out.println(action + " " + isbn + " quantity=" + qty);
			
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
				try {
					deleteBookFromCart(request, response, email, isbn);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("action = " + action);
			}
			else 
			{
				try {
					viewCart(request, response, email);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("action = " + action);
				System.out.println("Default to cart view");
			}
		}
		else {
			try {
				viewCart(request, response, email);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		Book book = Query.getBookByIsbn(isbn);
		
		//can't add more than what's in stock to cart
		if (book.getStock() - qty > 0) {
			Query.addToCart(email, book, qty); 
		}
		else
		{
			Query.addToCart(email, book, book.getStock());
		}
		
		viewCart(request,response,email);
	}

	private void changeQuantity(HttpServletRequest request, HttpServletResponse response, String email, String isbn, int qty) throws SQLException, ServletException, IOException {
		Book book = Query.getBookByIsbn(isbn);
		
		//can't add more than what's in stock to cart
		if (book.getStock() - qty > 0) {
			Query.setCartQuantity(email, book, qty); 
		}
		else
		{
			Query.setCartQuantity(email, book, book.getStock());
		}
		
		viewCart(request,response,email);
	}
	
	private void deleteBookFromCart(HttpServletRequest request, HttpServletResponse response, String email, String isbn) throws SQLException, ServletException, IOException {
		Book book = Query.getBookByIsbn(isbn);
		
		Query.deleteBookFromCart(email, book); 
		
		viewCart(request,response,email);
	}
	
	private void viewCart(HttpServletRequest request, HttpServletResponse response, String email) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher;
		ArrayList<Cart> books = Query.getBooksInCart(email);
		request.setAttribute("books", books);
		
		
		request.setAttribute("total", getCartTotal(books));
		dispatcher = request.getRequestDispatcher("/Cart.jsp"); 
		dispatcher.forward(request, response); 
	}
	
	private double getCartTotal(ArrayList<Cart> books) {
		double cartTotal = 0.00;
		for (int i=0; i < books.size(); i++) {
			cartTotal = cartTotal + books.get(i).getPrice() * books.get(i).getQty();
		}
		return cartTotal;
	}
}
