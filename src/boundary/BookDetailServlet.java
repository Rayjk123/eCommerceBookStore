package boundary;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain_layer.Book;
import logic_layer.Query;

@SuppressWarnings("serial")
@WebServlet("/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {
	
	
	public BookDetailServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("param");
		
		try {
			getBookByIsbn(request, response, isbn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	private void getBookByIsbn(HttpServletRequest request, HttpServletResponse response, String isbn) throws SQLException, ServletException, IOException {
		Book book = Query.getBookByIsbn(isbn);
		
		request.setAttribute("book", book);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/bookDetail.jsp");
		dispatcher.forward(request, response);
	}
}
