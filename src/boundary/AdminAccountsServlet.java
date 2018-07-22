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
import domain_layer.Customer;

@SuppressWarnings("serial")
@WebServlet("/AdminAccountsServlet")
public class AdminAccountsServlet extends HttpServlet {

	/**
     * @see HttpServlet#HttpServlet()
     */
	public AdminAccountsServlet(){
		super(); //HttpServlet constructor
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email"); 
		String permission = (String) session.getAttribute("permission");
		System.out.println("1" + email + " " + permission);
		
		/* TODO get permission and login check working
		
		if (email == null)
		{
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/login.html");
			dispatcher.forward(request, response);
		}
		
		// TODO check permission level and redirect to index if not admin
		if (permission == "admin") {
		*/
		
		
			servletHelper(request, response);
			
			
		/*}
		else {
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/login.html");
			System.out.println(email + " tried to access admin page");
			dispatcher.forward(request, response);
		}
		*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	
	/*
	 *  TODO servletHelper logic for parameters I need to pass
	 *  viewAllInventory
	 *  searchInventory (by column names)
	 *  editItemForm
	 */
	private void servletHelper(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("action") != null) { // TODO update this line with action for forms
			// TODO call search and edit functions... anything that needs input
			if (request.getParameter("action").equals("add")) {
				try {
					addUser(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (request.getParameter("action").equals("edit")) {
				try {
					editAccountPage(request,response,request.getParameter("email"));
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			try {
				viewUsers(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	private void viewUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher;
		ArrayList<Customer> customers = Query.getAllUsers();
		request.setAttribute("users", customers);
		
		dispatcher = request.getRequestDispatcher("/adminAccounts.jsp"); 
		dispatcher.forward(request, response); 
	}

	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Customer customer = new Customer(); 
		
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		customer.setFirstName(request.getParameter("first_name"));
		customer.setLastName(request.getParameter("last_name"));
		customer.setPermission(request.getParameter("permission"));
		customer.setSubscripion(request.getParameter("subscription"));
		
		String shippingStreet = request.getParameter("street").trim();
		String shippingCity = request.getParameter("city").trim();
		String shippingState = request.getParameter("state").trim();
		String shippingZip = request.getParameter("zip").trim();
		String shippingAddress = shippingStreet + " " + shippingCity + " " + shippingState + " " + shippingZip;
		customer.setStreetShipping(shippingStreet);
		customer.setCityShipping(shippingCity);
		customer.setStateShipping(shippingState);
		customer.setZipShipping(shippingZip);
		customer.setShippingAddress(shippingAddress);
		
		if (request.getParameter("sameAsBilling") != null) {
			customer.setStreetBilling(shippingStreet);
			customer.setCityBilling(shippingCity);
			customer.setStateBilling(shippingState);
			customer.setZipBilling(shippingZip);
			customer.setBillingAddress(shippingAddress);
			Query.addCustomer(customer);
		} else {
			String billingStreet = request.getParameter("b-street").trim();
			String billingCity = request.getParameter("b-city").trim();
			String billingState = request.getParameter("b-state").trim();
			String billingZip = request.getParameter("b-zip").trim();
			String billingAddress = billingStreet + " " + billingCity + " " + billingState + " " + billingZip;
			
			customer.setStreetBilling(billingStreet);
			customer.setCityBilling(billingCity);
			customer.setStateBilling(billingState);
			customer.setZipBilling(billingZip);
			customer.setBillingAddress(billingAddress);
			
			Query.addCustomer(customer);
		}
		
		viewUsers(request,response);
	}

	
	private void editAccountPage(HttpServletRequest request, HttpServletResponse response, String email) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher;
		Customer user = Query.getUserByEmail(email);
		
		request.setAttribute("user", user);
		
		dispatcher = request.getRequestDispatcher("/adminEditAccount.jsp"); 
		dispatcher.forward(request, response); 
	}
	/* TODO Change to suit Accounts view
	private void editItemSubmit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
	}
	*/
}
