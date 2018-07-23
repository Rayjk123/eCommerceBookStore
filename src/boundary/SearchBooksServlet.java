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
@WebServlet("/SearchBooksServlet")
public class SearchBooksServlet extends HttpServlet {
	
	
	public SearchBooksServlet() {
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
		if (request.getParameter("action") != null) {
			String action = request.getParameter("action");
			System.out.println("action = " + action);
			if (action.equals("title"))
			{
				try {
					searchByTitle(request, response, request.getParameter("search"));
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (action.equals("author")) {
				try {
					searchByAuthor(request,response, request.getParameter("search"));
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (action.equals("isbn")) {
				try {
					searchByIsbn(request, response, request.getParameter("search"));
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
			System.out.println("else");
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
		
		request.setAttribute("books", books);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/allBooks.jsp");
		dispatcher.forward(request, response);
	}
	
	private void searchByTitle(HttpServletRequest request, HttpServletResponse response, String title) throws ServletException, IOException, SQLException {
		ArrayList<Book> books = Query.getBooksByTitle(title);
		
		request.setAttribute("books", books);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/allBooks.jsp");
		dispatcher.forward(request, response);
	}
	
	private void searchByAuthor(HttpServletRequest request, HttpServletResponse response, String author) throws ServletException, IOException, SQLException {
		ArrayList<Book> books = Query.getBooksByAuthor(author);
		
		request.setAttribute("books", books);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/allBooks.jsp");
		dispatcher.forward(request, response);
	}
	
	private void searchByIsbn(HttpServletRequest request, HttpServletResponse response, String isbn) throws SQLException, ServletException, IOException {
		ArrayList<Book> books = Query.getBooksByIsbn(isbn);
		
		request.setAttribute("books", books);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/allBooks.jsp");
		dispatcher.forward(request, response);
	}
}
