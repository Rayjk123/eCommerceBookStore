package boundary;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic_layer.Query;

@WebServlet("/LoginValidation")
public class LoginValidation {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			validateLogin(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}
	
	private void validateLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if (!Query.validateLogin(email, password)) {
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/login.html");
			dispatcher.forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
				
		session = request.getSession();
		session.setAttribute("email", email);
				
		String permission = Query.getPermission(email);
		session.setAttribute("permission", permission);
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/index.html");
		dispatcher.forward(request, response);
		
		/** Can we do this so that login page returns to the soure 
		 * 
		String referer = "/" + request.getHeader("Referer");
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher(referer);
		dispatcher.forward(request, response);
		 *
		 */
	}
}
