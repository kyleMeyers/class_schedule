package classSchedule.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classSchedule.LoginController;
import classSchedule.ClassController;
import classSchedule.MajorController;
import classSchedule.ProfessorController;
import classSchedule.model.Course;
import classSchedule.model.Major;
import classSchedule.model.Professor;
import classSchedule.model.User;

public class ProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/professor.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String error = "";
		
		if(firstName == null || lastName == null)
		{
			error = "Please select a professor";
		}
		
		else
		{
			ProfessorController controller = new ProfessorController();
			Professor prof = controller.findProfessor(firstName, lastName);
			
			if(prof.getLastName() != null && prof.getFirstName() != null)
			{
				//Real professor
				req.getSession().setAttribute("firstName", prof.getFirstName());
				req.getSession().setAttribute("lastName", prof.getLastName());

				// Redirect to ?? page
				//resp.sendRedirect(req.getContextPath() + "/class");
				
				return;
			}
			else
			{
				error = "Unknown professor";
			}
		}
		
		req.setAttribute("firstName", firstName);
		req.setAttribute("lastName", lastName);
		req.setAttribute("error", error);
		
		req.getRequestDispatcher("/_view/professor.jsp").forward(req, resp);
	}
}
