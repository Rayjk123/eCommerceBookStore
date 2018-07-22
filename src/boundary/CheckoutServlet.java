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
import domain_layer.CreditCard;
import domain_layer.Customer;
import domain_layer.Order;

@SuppressWarnings("serial")
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

	/**
     * @see HttpServlet#HttpServlet()
     */
	public CheckoutServlet(){
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
			
			//TODO make a "process" order button and method 
			//TODO make a cancel button and method
			if (action.equals("edit"))
			{
				try {
					changeQuantity(request, response, email, isbn, qty);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (action.equals("delete"))
			{
				try {
					deleteBookFromCart(request, response, email, isbn);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else 
			{
				try {
					viewCheckout(request, response, email);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			try {
				viewCheckout(request, response, email);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
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
		
		viewCheckout(request,response,email);
	}
	
	private void deleteBookFromCart(HttpServletRequest request, HttpServletResponse response, String email, String isbn) throws SQLException, ServletException, IOException {
		Book book = Query.getBookByIsbn(isbn);
		
		Query.deleteBookFromCart(email, book); 
		
		viewCheckout(request,response,email);
	}
	
	private void viewCheckout(HttpServletRequest request, HttpServletResponse response, String email) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher;
		ArrayList<Cart> books = Query.getBooksInCart(email);
		
		Customer customer = Query.getUserByEmail(email);
		CreditCard card = Query.getCreditCardInfo(email);
		double cartTotal = getCartTotal(books);
		double shipping = getShippingCost(customer.getAddress());
		double taxes = getTaxes(customer.getAddress(), cartTotal);
		double total = cartTotal + shipping + taxes;
		
		request.setAttribute("books", books);
		request.setAttribute("cartTotal", cartTotal);
		request.setAttribute("shippingCost", shipping);
		request.setAttribute("taxesCost", taxes);
		request.setAttribute("orderTotal", total);
		request.setAttribute("user", customer);
		request.setAttribute("card", card);
		
		dispatcher = request.getRequestDispatcher("/checkout.jsp"); 
		dispatcher.forward(request, response); 
	}
	
	private void submitOrder(HttpServletRequest request, HttpServletResponse response, String email) throws SQLException {
		RequestDispatcher dispatcher;
		ArrayList<Cart> books = Query.getBooksInCart(email);
		
		Customer customer = Query.getUserByEmail(email);
		CreditCard card = Query.getCreditCardInfo(email);
		
		double total;
		
		Order order = new Order();
	}
	
	private double getCartTotal(ArrayList<Cart> books) {
		double cartTotal = 0.00;
		for (int i=0; i < books.size(); i++) {
			cartTotal = cartTotal + books.get(i).getPrice() * books.get(i).getQty();
		}
		return cartTotal;
	}
	
	private double getShippingCost(String shippingAddress) {
		double shippingCost = 3.25; //flat rate
		
		// TODO calculate shipping method given destination address
		
		return shippingCost;
	}
	
	private double getTaxes(String address, double cartTotal) {
		double taxPercentage = 0.06;
		double taxes = cartTotal * taxPercentage;
		
		//TODO calculate taxes based on regulations given the address
		
		return taxes;
	}
}
