package boundary;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic_layer.Query;

@WebServlet("/Confirmation")
public class Confirmation {
	
	public Confirmation() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		confirmRegistration(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void confirmRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		
		String confirmationCode = request.getParameter("ref-confirmation").trim();
		
		try {
			if (Query.confirmationCodeValid(confirmationCode)) {
				dispatcher = request.getRequestDispatcher("/registrationConfirmation.html");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("/registrationFailure.html");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dispatcher = request.getRequestDispatcher("/registrationConfirmation.html");
			dispatcher.forward(request, response);
		}
	}
}
