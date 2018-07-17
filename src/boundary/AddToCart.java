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

import logic_layer.Query;

@WebServlet("/CartControl")
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
		dispatcher = request.getRequestDispatcher("/bookDetail.html"); //TODO what actually should be here?
		dispatcher.forward(request, response); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void addToCart(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String email = request.getParameter("email").trim();
		
		//the request identifies the user
		//accountID (Users DB key) associates to the users cart in the Cart DB
	
	}
}
