package classSchedule.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classSchedule.LoginController;
import classSchedule.ClassController;
import classSchedule.MajorController;
import classSchedule.model.Course;
import classSchedule.model.Major;
import classSchedule.model.User;

public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/class.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		//Object maj = req.getSession().getAttribute("maj");
		String error = "";
		
		ClassController controller = new ClassController();		//make a new controller for each servlet
		
		/**
		 * Use "findCoursesbyMajor()" here to obtain list of Major required Courses.
		 * Need:
		 * 		-Current User
		 * 		-User's Major
		 * - How are these obtained?
		 * 
		 * Should "findCoursesbyMajor()" be part of the CourseController or MajorController?
		 * Once list of Courses obtained, should be trivial to display.
		 */
		
	}
}
