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

import domain_layer.Customer;
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
		
		Customer customer = new Customer();
		
		customer.setEmail(email);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setPassword(password);
		customer.setStreetShipping(shippingStreet);
		customer.setCityShipping(shippingCity);
		customer.setStateShipping(shippingState);
		customer.setZipShipping(shippingZip);
		customer.setShippingAddress(shippingAddress);
		customer.setPermission("customer");
		
		// Means that the checkbox has been set
		if (request.getParameter("sameAsBilling") != null) {
			customer.setStreetBilling(shippingStreet);
			customer.setCityBilling(shippingCity);
			customer.setStateBilling(shippingState);
			customer.setZipBilling(shippingZip);
			customer.setBillingAddress(shippingAddress);
			
			//Query.insertNewUser(email, password, firstName, lastName, "customer", shippingAddress, shippingAddress);
			Query.addCustomer(customer);
		} else {
			String billingStreet = request.getParameter("b-street").trim();
			String billingCity = request.getParameter("b-city").trim();
			String billingState = request.getParameter("b-state").trim();
			String billingZip = request.getParameter("b-zip").trim();
			String billingAddress = billingStreet + " " + billingCity + " " + billingState + " " + billingZip;
			
			customer.setStreetBilling(billingStreet);
			customer.setCityBilling(billingCity);
			customer.setStateBilling(billingState);
			customer.setZipBilling(billingZip);
			customer.setBillingAddress(billingAddress);
			
			//Query.insertNewUser(email, password, firstName, lastName, "customer", shippingAddress, billingAddress);
			Query.addCustomer(customer);
		}
		
		if (!Query.insertCreditCard(email, cardNumber, security, expDate)) {
			dispatchToFailure(request, response);
			return;
		}
		
		if (Query.addConfirmationCode(email, confirmationCode)) {
			System.out.println("Added Confirmation COde");
			dispatcher = request.getRequestDispatcher("/registrationConfirmation.html");
			dispatcher.forward(request, response);
			sendEmail(email, confirmationCode);
			return;
		}
		
		System.out.println("Failed Confirmation COde");
		dispatchToFailure(request, response);
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
		
		return code.toString();
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
			message.setFrom(new InternetAddress("csci4050uga@gmail.com"));
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
