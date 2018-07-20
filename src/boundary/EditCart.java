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

@SuppressWarnings("serial")
@WebServlet("/EditCart")
public class EditCart extends HttpServlet {

	/**
     * @see HttpServlet#HttpServlet()
     */
	public EditCart(){
		super(); //HttpServlet constructor
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			editCart(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void editCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		ArrayList<Book> books = Query.getBooksInCart(email);
		request.setAttribute("books", books);
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/Cart.jsp"); //TODO what actually should be here?
		dispatcher.forward(request, response); 
	}
}
