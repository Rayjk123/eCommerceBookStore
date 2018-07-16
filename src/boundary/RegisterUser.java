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

@WebServlet("/SignUpServlet")
public class RegisterUser extends HttpServlet {

	/**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			completeRegistration(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/confirm_account.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void completeRegistration(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String email = request.getParameter("email").trim();
		
		if (Query.emailExists(email)) {
			System.out.println("Email Exists");
			// TODO: SEND RESPONSE AND UPDATE WITH AJAX
			
			return;
		}
		
		String firstName = request.getParameter("firstname").trim();
		String lastName = request.getParameter("lastname").trim();
		String password = request.getParameter("password").trim();
		
		Query.insertNewUser(email, password, firstName, lastName, "customer");
		
		String shippingStreet = request.getParameter("street").trim();
		String shippingCity = request.getParameter("city").trim();
		String shippingState = request.getParameter("state").trim();
		String shippingZip = request.getParameter("zip").trim();
		String shippingAddress = shippingStreet + " " + shippingCity + " " + shippingState + " " + shippingZip;
		
		String cardNumber = request.getParameter("ccNumber").trim();
		String expDate = request.getParameter("exp-month") + "/" + request.getParameter("exp-year");
		String security = request.getParameter("ccSecurity").trim();
		
		String confirmationCode = randomString();
	}
	
	private boolean shippingInformationValid(HttpServletRequest request) {
		return (request.getParameter("street").trim().equals(""));
	}
	
	private String randomString() {
		Random rand = new Random();
		StringBuilder code = new StringBuilder();
		
		for (int i = 0; i < 6; i++) {
			code.append(rand.nextInt(10));
		}
		
		return rand.toString();
	}
}
