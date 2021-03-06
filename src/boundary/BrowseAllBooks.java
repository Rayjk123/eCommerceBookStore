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

import domain_layer.Book;
import logic_layer.Query;

@SuppressWarnings("serial")
@WebServlet("/BrowseAllBooks")
public class BrowseAllBooks extends HttpServlet {
	
	
	public BrowseAllBooks() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servletHelper(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void servletHelper(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("genre") != null) {
			String genre = request.getParameter("genre");
			System.out.println("genre = " + genre);
			//TODO genre logic
			if (genre.equals("Fantasy") || genre.equals("Romance") || genre.equals("Horror")) {
				try {
					displayByGenre(request,response,genre);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					displayAllBooks(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			try {
				displayAllBooks(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void displayAllBooks(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		ArrayList<Book> books = Query.getAllBooks();
		
		String message = "Browse All Books";
		
		request.setAttribute("books", books);
		request.setAttribute("message", message);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/allBooks.jsp");
		dispatcher.forward(request, response);
	}
	
	private void displayByGenre(HttpServletRequest request, HttpServletResponse response, String genre) throws SQLException, ServletException, IOException {
		ArrayList<Book> books = Query.getBooksByGenre(genre);
		
		String message = "Browse " + genre + " Books";
		
		request.setAttribute("books", books);
		request.setAttribute("message", message);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/allBooks.jsp");
		dispatcher.forward(request, response);
	}
}
