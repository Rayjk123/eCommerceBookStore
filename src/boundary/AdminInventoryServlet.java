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
@WebServlet("/AdminInventoryServlet")
public class AdminInventoryServlet extends HttpServlet {

	/**
     * @see HttpServlet#HttpServlet()
     */
	public AdminInventoryServlet(){
		super(); //HttpServlet constructor
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email"); 
		String permission = (String) session.getAttribute("permission");

		// TODO allow login refers back to Cart
		if (email == null)
		{
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/login.html");
			dispatcher.forward(request, response);
		}
		
		// TODO check permission level and redirect to index if not admin
		if (permission == "admin") {
			servletHelper(request, response);
		}
		else {
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/login.html");
			System.out.println(email + " tried to access admin page");
			dispatcher.forward(request, response);
		}
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
		}
		else {
			try {
				viewInventory(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	private void viewInventory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher;
		ArrayList<Book> books = Query.getAllBooks();
		request.setAttribute("books", books);
		
		dispatcher = request.getRequestDispatcher("/AdminInventory.jsp"); 
		dispatcher.forward(request, response); 
	}
}
