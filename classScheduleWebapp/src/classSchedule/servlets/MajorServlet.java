package classSchedule.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import classSchedule.LoginController;
import classSchedule.MajorController;
import classSchedule.model.Major;
import classSchedule.model.User;
import classSchedule.model.Course;
import classSchedule.persist.InitialData;

public class MajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List <Major> allMajors= InitialData.getMajors();
		req.getSession().setAttribute("allMajors", allMajors);
		req.getRequestDispatcher("/_view/major.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		String major = req.getParameter("major");
		String error = "";
		//List <Major> allMajors= InitialData.getMajors();
		//List <Course> allCourses;
		
		
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
				req.getSession().setAttribute("crn", maj);
				//req.getSession().setAttribute("allMajors", allMajors);
				
				
				// Redirect to schedule page
				resp.sendRedirect(req.getContextPath() + "/class");
				
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
