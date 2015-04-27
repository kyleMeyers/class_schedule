package classSchedule.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import classSchedule.ClassController;
import classSchedule.model.Course;

import classSchedule.model.Major;
import classSchedule.model.User;
import classSchedule.persist.InitialData;


public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//List <Course> allCourses = InitialData.getCourses();
		//req.getSession().setAttribute("allCourses", allCourses);
		req.getRequestDispatcher("/_view/class.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		//Major major = (Major) req.getSession().getAttribute("maj");
		//String course = req.getParameter("course");
		String crn = req.getParameter("crn");
		String error = "";
		
		
		if(crn == null)
		{
			error = "Please click a course";
		}
		
		else
		{
			ClassController controller = new ClassController();
			List<Course> courseTitles = controller.findCourseByMajor(crn);
			if(courseTitles.size() < 1)
			{
				System.out.println("I got nothing");
			}
			for(int i = 0; i < courseTitles.size(); i++)
				System.out.println(courseTitles.get(i).getName());
			
			if(courseTitles != null)
			{
				//Real course
				req.getSession().setAttribute("courseList", courseTitles);
				
				
				// Redirect to ?? page
				//resp.sendRedirect(req.getContextPath() + "/class");
				
				return;

			}
			else
			{
				error = "Unknown course";
			}
		}
		
		//req.setAttribute("course", course);
		req.setAttribute("crn", crn);
		req.setAttribute("error", error);
		
		req.getRequestDispatcher("/_view/class.jsp").forward(req, resp);

	}
}
