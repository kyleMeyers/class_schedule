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

		String coursetitle = req.getParameter("courseItem");
		List<Course> classes = (List<Course>) req.getSession().getAttribute("allCourses");
		
		for(Course item: classes){
			if (item.getName().equalsIgnoreCase(coursetitle))
			{
				req.getSession().setAttribute("selectedCourse", item);
				resp.sendRedirect(req.getContextPath() + "/courseDescription");
				
				return;
			}
		}
		return;

	}
}
