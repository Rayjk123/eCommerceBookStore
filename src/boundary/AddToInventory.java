package boundary;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import logic_layer.Query;
import domain_layer.Book;

@SuppressWarnings("serial")
@WebServlet("/AddToInventory")
public class AddToInventory extends HttpServlet {

	/**
     * @see HttpServlet#HttpServlet()
     */
	public AddToInventory(){
		super(); //HttpServlet constructor
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			addBookToInventory(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void addBookToInventory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Book book = new Book();
		//TODO Empty field handling, right now they're all required to avoid empty String in query
		//TODO Error Handling for inputs
		book.setIsbn(request.getParameter("isbn"));
		book.setTitle(request.getParameter("title"));
		book.setAuthor(request.getParameter("author"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setGenre(request.getParameter("genre"));
		book.setPublisher(request.getParameter("publisher"));
		book.setVendor(request.getParameter("vendor"));
		book.setStock(Integer.parseInt(request.getParameter("stock")));
		book.setPromoCode(request.getParameter("promocode"));
		book.setPromoPrice(Double.parseDouble(request.getParameter("promoprice")));
		book.setImage(request.getParameter("image"));
		book.setDescription(request.getParameter("description"));
		
		Query.addBookToInventory(book);
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/adminInventory.html"); 
		dispatcher.forward(request, response); 
	}
}
