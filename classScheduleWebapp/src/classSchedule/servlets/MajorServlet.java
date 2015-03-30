package classSchedule.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classSchedule.LoginController;
import classSchedule.MajorController;
import classSchedule.model.Major;
import classSchedule.model.User;

public class MajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/major.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		String major = req.getParameter("major");
		String error = "";
		
		if(major == null)
		{
			error = "Please enter a major";
		}
		else
		{
			MajorController controller = new MajorController();		//make a new controller for each servlet
			Major maj = controller.findMajor(major);
			
			if(maj != null)
			{
				//Real major
				req.getSession().setAttribute("maj", maj);
				
				// Redirect to schedule page
				resp.sendRedirect(req.getContextPath() + "/schedule");
				
				return;
			}
			else
			{
				error = "Unknown major";
			}
		}
		
		req.setAttribute("major", major);
		req.setAttribute("error", error);
		
		req.getRequestDispatcher("/_view/major.jsp").forward(req, resp);
	}
}
