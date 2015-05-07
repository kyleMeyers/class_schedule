package classSchedule.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classSchedule.DescriptionController;
import classSchedule.model.Course;
import classSchedule.model.Description;
import classSchedule.model.User;



public class DescriptionServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private List<Course> done = new ArrayList<Course>();
		private List<Course> scheduled = new ArrayList<Course>();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			//gets the current course selected from the web page and gets the description of the respective course
			//then sets the attribute of the course for the jsps
			DescriptionController controller = new DescriptionController();
			Course current = (Course) req.getSession().getAttribute("selectedCourse");
			
			Description desc = controller.findDescriptionByCourse(current);
			//System.out.println(""+desc.getDescript());
			
			req.getSession().setAttribute("descr", desc);
			
			req.getRequestDispatcher("/_view/courseDescription.jsp").forward(req, resp);
		}

		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
			
			//TODO: if button pressed to either add to done list or to do for scheduling list then make them go back to
			//class.jsp to pick out another class
			
			Course selected = (Course) req.getSession().getAttribute("selectedCourse");
			
			DescriptionController controller = new DescriptionController();
			User user = (User) req.getSession().getAttribute("user");
			Course course = (Course) req.getSession().getAttribute("selectedCourse");
			
			if(req.getParameter("todo") != null)
			{
				//System.out.println("The user pressed TODO");
				scheduled.add(selected);
				req.getSession().setAttribute("todoList", scheduled);
				controller.storeCoursesForUsers(user, course);
				resp.sendRedirect(req.getContextPath() + "/class");
				
			}
			
			if(req.getParameter("completed") != null)
			{
				//System.out.println("The user completed this course");
				done.add(selected);
				req.getSession().setAttribute("doneList", done);
				controller.storeCoursesForUsersDone(user, course);
				resp.sendRedirect(req.getContextPath() + "/class");
				
				
			}
			return;
		}
}
