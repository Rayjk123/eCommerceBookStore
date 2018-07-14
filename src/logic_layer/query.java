package logic_layer;

import data_access_layer.DbAccess;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class query {
	/*
	 * This method is called from the Login_Servlet, and it creates a query to that is executed to enter a new user into the database.
	 */
	public static int insert_new_user(HttpServletRequest request, HttpServletResponse response, String name, String email, String password) {
		String query = "INSERT INTO users (name, email, password) Values('"+name+"', '"+email+"', '"+password+"')";
		int r = 0;
		try{
			r = DbAccess.insert(query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return r;
	}
}
