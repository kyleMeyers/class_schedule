package classSchedule.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classSchedule.LoginController;
import classSchedule.model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException ,IOException {
		String username = req.getParameter("username");			//get the username from the user who enters it
		String password = req.getParameter("password");			//get the password from the user who enters it
		
		String error = "";
		if (username == null || password == null) {
			error = "Please enter a username and password.";
		} else {
			LoginController controller = new LoginController();		//make a new controller for each servlet
			User user = controller.findUser(username, password);	//find the user from the input
			if (user != null) {										//checks to make sure it is a valid user
				// Successful login!
				
				// Add user to session
				req.getSession().setAttribute("user", user);		//makes sure the user is logged in and the attribute 
																	//can be accessed by any servlet now
				
				// Redirect to schedule page
				resp.sendRedirect(req.getContextPath() + "/schedule");	//after a successful session on a servlet you should
																		//redirect the page to another servlet. This case is schedule
				return;
			} else {
				// Invalid username/password
				error = "Unknown username/password";
			}
		}
														//this can be all used in the html code
		req.setAttribute("username", username);			//sets the attribute for the username for the input
		req.setAttribute("password", password);			//sets the attribute for the password for the input
		req.setAttribute("error", error);				//sets the error msg for the html code
		
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
}
