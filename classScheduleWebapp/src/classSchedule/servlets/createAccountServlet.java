package classSchedule.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import classSchedule.ClassController;
import classSchedule.createAccountController;
import classSchedule.model.Course;
import classSchedule.model.Major;
import classSchedule.model.User;
import classSchedule.persist.InitialData;

public class createAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/createAccount.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException ,IOException {
		String username = req.getParameter("username");			//get the username from the user who enters it
		String password = req.getParameter("password");			//get the password from the user who enters it
		int numusers = InitialData.getUsers().size() + 1;
		
		String error = "";
		if (username == null || password == null) {
			error = "Please enter a username and password.";
		} else {
			createAccountController controller = new createAccountController();		//make a new controller for each servlet

			User user = controller.findUser(username, password);	//find the user from the input
			if (user == null) {										//checks to make sure it is a valid user
				// Successful login!
				
				// Add user to session
				user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setId(numusers);
				
				req.getSession().setAttribute("user", user);		//makes sure the user is logged in and the attribute 
																	//can be accessed by any servlet now
				
				// Redirect to major page
				resp.sendRedirect(req.getContextPath() + "/major");		//after a successful session on a servlet you should
																		//redirect the page to another servlet. This case is schedule
				return;
			} else {
				// Invalid username/password
				error = "This user already exists";
			}
		}
														//this can be all used in the html code
		req.setAttribute("username", username);			//sets the attribute for the username for the input
		req.setAttribute("password", password);			//sets the attribute for the password for the input
		req.setAttribute("error", error);				//sets the error msg for the html code
		
		req.getRequestDispatcher("/_view/createAccount.jsp").forward(req, resp);
	}
}