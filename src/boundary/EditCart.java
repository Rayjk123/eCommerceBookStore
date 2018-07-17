package boundary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
import javax.servlet.http.Cookie;

import logic_layer.Query;
import domain_layer.Book;
import domain_layer.Customer;

@WebServlet("/AddToCart")
public class EditCart extends HttpServlet {

	/**
     * @see HttpServlet#HttpServlet()
     */
	public EditCart(){
		super(); //HttpServlet constructor
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		
		try {
			EditCart(request, response, session);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/bookDetail.html"); //TODO what actually should be here?
		dispatcher.forward(request, response); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void EditCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException {
		Customer customer = (Customer)session.getAttribute("customer");
		
		
	}
}
