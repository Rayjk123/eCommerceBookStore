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
import domain_layer.Order;

@SuppressWarnings("serial")
@WebServlet("/AdminOrdersServlet")
public class AdminOrdersServlet extends HttpServlet {

	/**
     * @see HttpServlet#HttpServlet()
     */
	public AdminOrdersServlet(){
		super(); //HttpServlet constructor
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email"); 
		String permission = (String) session.getAttribute("permission");
		
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
			String input = request.getParameter("action");
			
			String[] parseAction = input.split("_", 2);
			String action = parseAction[0];
			int actionOrderNumber = Integer.parseInt(parseAction[1]);
			
			String status = request.getParameter("status_" + actionOrderNumber);
			
			if (action.equals("update")) {
				try {
					updateStatus(request,response, actionOrderNumber, status);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					viewOrders(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			try {
				viewOrders(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	private void viewOrders(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher;
		ArrayList<Order> orders = Query.getAllOrders();
		request.setAttribute("orders", orders);
		
		dispatcher = request.getRequestDispatcher("/adminOrders.jsp"); 
		dispatcher.forward(request, response); 
	}
	
	
	private void updateStatus(HttpServletRequest request, HttpServletResponse response, int actionOrderNumber, String status) throws SQLException, ServletException, IOException {
		
		Query.updateOrderStatus(status, actionOrderNumber);
		
		viewOrders(request,response);
	}
}
