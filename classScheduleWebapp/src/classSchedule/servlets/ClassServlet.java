package classSchedule.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classSchedule.ClassController;
import classSchedule.model.Course;

public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/class.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		String course = req.getParameter("course");
		String crn = req.getParameter("crn");
		String error = "";
		
		if(course == null)
		{
			error = "Please click a course";
		}
		
		else
		{
			ClassController controller = new ClassController();
			Course courseTitle = controller.findCoursebyTitleOrCrn(course, crn);
			
			if(courseTitle != null)
			{
				//Real course
				req.getSession().setAttribute("course", courseTitle);
				
				// Redirect to ?? page
				//resp.sendRedirect(req.getContextPath() + "/class");
				
				return;
			}
			else
			{
				error = "Unknown course";
			}
		}
		
		req.setAttribute("course", course);
		req.setAttribute("crn", crn);
		req.setAttribute("error", error);
		
		req.getRequestDispatcher("/_view/class.jsp").forward(req, resp);
	}
}
