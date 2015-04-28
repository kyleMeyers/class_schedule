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
		Major major = (Major) req.getSession().getAttribute("maj");
		System.out.println(major.getName() + "**");
		//String course = req.getParameter("course");
		String crn = req.getParameter("crn");
		String error = "";

		ClassController controller = new ClassController();
		//Course courseTitle = controller.findCourseByMajor(crn);

		Course test = new Course();
		test.setId(6);
		test.setCRN("CS");
		test.setName("Whoop di doo");

		User person = (User) req.getSession().getAttribute("user");
		Major current = controller.findMajorByUser(person);
		System.out.println("" + test.getName());
		List<Course> classes = controller.findCourseByMajor(major);

		classes.add(test);
		classes.add(test);
		classes.add(test);
		if(classes != null)
		{
			//Real course
			req.getSession().setAttribute("allCourses", classes);

			// Redirect to ?? page
			//resp.sendRedirect(req.getContextPath() + "/class");

			return;
		}

		//req.setAttribute("course", course);
		//req.setAttribute("crn", crn);
		//req.setAttribute("error", error);
		
		req.getRequestDispatcher("/_view/class.jsp").forward(req, resp);

	}
}
