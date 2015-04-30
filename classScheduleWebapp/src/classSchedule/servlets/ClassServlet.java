package classSchedule.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classSchedule.ClassController;
import classSchedule.model.Course;

import classSchedule.model.Major;


public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ClassController controller = new ClassController();
		//User person = (User) req.getSession().getAttribute("user");
		//Major current = controller.findMajorByUser(person);
		Major major = (Major) req.getSession().getAttribute("maj");
		
		List<Course> classes = controller.findCourseByMajor(major);
		req.getSession().setAttribute("allCourses", classes);
		
		req.getRequestDispatcher("/_view/class.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		
		//TODO:if button hit to display courses then go to the courseDescription Servlet
		
	
		//req.setAttribute("course", course);
		//req.setAttribute("crn", crn);
		//req.setAttribute("error", error);

		//req.getRequestDispatcher("/_view/class.jsp").forward(req, resp);

	}
}
