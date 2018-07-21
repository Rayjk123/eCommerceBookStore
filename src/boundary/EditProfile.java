package boundary;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain_layer.Customer;
import logic_layer.Query;

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet{
	
	public EditProfile() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			editProfile(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void editProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String email = getSessionEmail(request);
		RequestDispatcher dispatcher;
		
		if (email == null) {
			System.out.println("Entered EditProfile");
			dispatcher = request.getRequestDispatcher("/login.html");
			dispatcher.forward(request, response);
			return;
		}
		
		Customer customer = Query.getCustomerInfo(email);
		
		request.setAttribute("customers", customer);
		dispatcher = request.getRequestDispatcher("/editProfile.jsp");
		dispatcher.forward(request, response);
	}
	
	private String getSessionEmail(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (session == null) {
			return null;
		}
		
		return (String) session.getAttribute("email"); 
	}
}
