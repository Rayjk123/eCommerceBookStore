package boundary;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		if (request.getParameter("action") != null) {
			String action = request.getParameter("action");
			
			if (action.equals("submit")) {
				try {
					submitOrder(request, response, email);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					viewCheckout(request,response,email);
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
	
	private void submitOrder(HttpServletRequest request, HttpServletResponse response, String email) throws SQLException, ServletException, IOException {
		ArrayList<Cart> books = Query.getBooksInCart(email);
		
		Order order = new Order();
		
		String shippingStreet = request.getParameter("street").trim();
		String shippingCity = request.getParameter("city").trim();
		String shippingState = request.getParameter("state").trim();
		String shippingZip = request.getParameter("zip").trim();
		String shippingAddress = shippingStreet + " " + shippingCity + " " + shippingState + " " + shippingZip;
		String billingAddress;
		if (request.getParameter("sameAsBilling") != null) {
			billingAddress = shippingAddress;
		} else {
			String billingStreet = request.getParameter("b-street").trim();
			String billingCity = request.getParameter("b-city").trim();
			String billingState = request.getParameter("b-state").trim();
			String billingZip = request.getParameter("b-zip").trim();
			billingAddress = billingStreet + " " + billingCity + " " + billingState + " " + billingZip;
		}
		double cartTotal = getCartTotal(books);
		double shipping = getShippingCost(shippingAddress);
		double taxes = getTaxes(shippingAddress, cartTotal);
		double total = cartTotal + shipping + taxes;
		
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");  
		Date dateObject = new Date(); 
		String date = formatter.format(dateObject);
		
		order.setEmail(email);
		order.setDate(date);
		order.setTotal(total);
		order.setSubTotal(cartTotal);
		order.setTax(taxes);
		order.setShippingCost(shipping);
		order.setShippingAddress(shippingAddress);
		order.setBillingAddress(billingAddress);
		
		if (request.getParameter("storePickup") != null) {
			order.setStatus("Hold for Pickup");
			
			Query.addPickupOrder(order);
			for (int i = 0; i < books.size(); i++) {
				int hold = books.get(i).getQty();
				Query.setHold(books.get(i), hold);
			}
			
			String pickupMessage = "Your order has been successfully processed! You will have 5 days from today, " 
			+ date + ",  to pickup your order before it is purged from our systems.";
			
			request.setAttribute("orderMessage", pickupMessage);
			
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/orderConfirmation.jsp"); 
			dispatcher.forward(request, response);
		}
		else {
			order.setStatus("Online Payment Processed");
			//TODO replace with credit card validity test, right now we just test null
			if (request.getParameter("ccNumber") != null & request.getParameter("ccSecurity") != null & request.getParameter("exp-month") != null & request.getParameter("exp-year") != null) {
				order.setPaymentCard(request.getParameter("ccNumber"));
				
				Query.addCardOrder(order);
				for (int i = 0; i < books.size(); i++) {
					Book book = Query.getBookByIsbn(books.get(i).getIsbn());
					
					int orderAmount = books.get(i).getQty();
					int stock = book.getStock() - orderAmount;
					Query.updateBookStock(book, stock);
				}
				
				Query.deleteCart(email);
				
				String orderMessage = "Your order has been successfully processed and will be delivered to you in a jiffy!";
				
				request.setAttribute("orderMessage", orderMessage);
				
				RequestDispatcher dispatcher;
				dispatcher = request.getRequestDispatcher("/orderConfirmation.jsp"); 
				dispatcher.forward(request, response);
			}
			else {
				viewCheckout(request, response, email);
			}
		}
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
