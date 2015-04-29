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
		Major major = (Major) req.getSession().getAttribute("maj");
		ClassController controller = new ClassController();
		List<Course> classes = controller.findCourseByMajor(major);
		req.getSession().setAttribute("allCourses", classes);
		
		req.getRequestDispatcher("/_view/class.jsp").forward(req, resp);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		//System.out.println("I did something");
		//String course = req.getParameter("course");
		//String crn = req.getParameter("crn");
		//String error = "";

		//Course test = new Course();
		//test.setId(6);
		//test.setCRN("CS");
		//test.setName("Whoop di doo");

		//User person = (User) req.getSession().getAttribute("user");
		//Major current = controller.findMajorByUser(person);

		//classes.add(test);
		//classes.add(test);
		//classes.add(test);
		//if(classes != null)
		//{

			// Redirect to ?? page
			//resp.sendRedirect(req.getContextPath() + "/class");

			

		//}
		//req.setAttribute("course", course);
		//req.setAttribute("crn", crn);
		//req.setAttribute("error", error);

		//req.getRequestDispatcher("/_view/class.jsp").forward(req, resp);
		String coursetitle = req.getParameter("coursetitle");
		List<Course> classes = (List<Course>)req.getSession().getAttribute("allCourses");
		
		for(Course item: classes){
			if (item.getName().equalsIgnoreCase(coursetitle))
			{
				req.getSession().setAttribute("selectedCourse", item);
				resp.sendRedirect(req.getContextPath() + "/courseDescriptin");
				
				System.out.println("I found what I wanted");
				return;
			}
		}
		return;

	}
}
