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

		//System.out.println("I got here");
		
		//TODO:if button hit to display courses then go to the courseDescription Servlet
		//also set that course to a new attribute to be used in the description
		
		//Course current = new Course();
		
		//Course get = (Course) req.getAttribute("courseItem");
		
		
		
		

		//req.setAttribute("course", course);
		//req.setAttribute("error", error);

		//req.getRequestDispatcher("/_view/class.jsp").forward(req, resp);
		String coursetitle = req.getParameter("courseItem");
		List<Course> classes = (List<Course>) req.getSession().getAttribute("allCourses");
		
		for(Course item: classes){
			
			//System.out.println(item.getName());
			//System.out.println(coursetitle);
			if (item.getName().equalsIgnoreCase(coursetitle))
			{
				req.getSession().setAttribute("selectedCourse", item);
				resp.sendRedirect(req.getContextPath() + "/courseDescription");
				
				System.out.println("I found what I wanted");
				return;
			}
		}
		return;

	}
}
