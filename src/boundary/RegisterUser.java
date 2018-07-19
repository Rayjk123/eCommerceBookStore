package boundary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic_layer.Query;

@WebServlet("/RegisterUser")
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
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void completeRegistration(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher;
		String email = request.getParameter("email").trim();
		
		if (Query.emailExists(email)) {
			dispatchToFailure(request, response);
			return;
		}
		
		String firstName = request.getParameter("firstname").trim();
		String lastName = request.getParameter("lastname").trim();
		String password = request.getParameter("password").trim();
		
		String shippingStreet = request.getParameter("street").trim();
		String shippingCity = request.getParameter("city").trim();
		String shippingState = request.getParameter("state").trim();
		String shippingZip = request.getParameter("zip").trim();
		String shippingAddress = shippingStreet + " " + shippingCity + " " + shippingState + " " + shippingZip;
		
		String cardNumber = request.getParameter("ccNumber").trim();
		String expDate = request.getParameter("exp-month") + "/" + request.getParameter("exp-year");
		String security = request.getParameter("ccSecurity").trim();
		
		String confirmationCode = randomString();
		
		// Means that the checkbox has been set
		if (request.getParameter("sameAsBilling") != null) {
			Query.insertNewUser(email, password, firstName, lastName, "customer", shippingAddress, shippingAddress);
			return;
		}
		
		String billingStreet = request.getParameter("b-street").trim();
		String billingCity = request.getParameter("b-city").trim();
		String billingState = request.getParameter("b-state").trim();
		String billingZip = request.getParameter("b-zip").trim();
		String billingAddress = billingStreet + " " + billingCity + " " + billingState + " " + billingZip;
		
		Query.insertNewUser(email, password, firstName, lastName, "customer", shippingAddress, billingAddress);
		
		if (Query.addConfirmationCode(email, confirmationCode)) {
			dispatchToFailure(request, response);
			sendEmail(email, confirmationCode);
			return;
		}
		
		dispatcher = request.getRequestDispatcher("/registrationConfirmation.html");
		dispatcher.forward(request, response);
	}
	
	private boolean shippingInformationValid(HttpServletRequest request) {
		return (request.getParameter("street").trim().equals(""));
	}
	
	private void dispatchToFailure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/registrationFailure.html");
		dispatcher.forward(request, response);
	}
	
	private String randomString() {
		Random rand = new Random();
		StringBuilder code = new StringBuilder();
		
		for (int i = 0; i < 6; i++) {
			code.append(rand.nextInt(10));
		}
		
		return rand.toString();
	}
	
	/*
     * Method for sending confirmation email
     * reference:
     * https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
     */
    protected void sendEmail(String email, String code) {
    	final String username = "csci4050uga@gmail.com";
		final String password = "csci4050uga!";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("cs4050team10@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Welcome to the Bookstore!");
			message.setText("Your verification code is " + code);

			Transport.send(message);


		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
