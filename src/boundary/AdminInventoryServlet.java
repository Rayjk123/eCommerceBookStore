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
			
			String input = request.getParameter("action");
			
			String[] parse = input.split("_", 2);
			String action = parse[0];
			String isbn = parse[1];
			
			System.out.println(action + " " + isbn);
			
			if (action.equals("add")) {
				try {
					addItem(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (action.equals("edit")) {
				try {
					editItemPage(request,response,isbn);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if (request.getParameter("action").equals("update")) {
				try {
					editItemSubmit(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (request.getParameter("action").equals("cancel")) {
				try {
					viewInventory(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (action.equals("delete")) {
				try {
					deleteItem(request, response, isbn);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		
		dispatcher = request.getRequestDispatcher("/adminInventory.jsp"); 
		dispatcher.forward(request, response); 
	}
	
	private void addItem(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Book book = new Book();
		
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
		
		viewInventory(request,response);
		
	}
	
	private void deleteItem(HttpServletRequest request, HttpServletResponse response, String isbn) throws SQLException, ServletException, IOException {
		Query.deleteItem(isbn);
		
		viewInventory(request, response);
	}
	
	private void editItemPage(HttpServletRequest request, HttpServletResponse response, String isbn) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher;
		Book book = Query.getBookByIsbn(isbn);
		request.setAttribute("book", book);
		
		dispatcher = request.getRequestDispatcher("/adminEditInventory.jsp"); 
		dispatcher.forward(request, response); 
	}
	
	private void editItemSubmit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Book book = new Book();
		
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
		
		Query.updateInventory(book);
		
		viewInventory(request,response);
	}
}
