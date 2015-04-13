package classSchedule.servlets;

import java.io.IOException;

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
		
		resp.sendRedirect(req.getContextPath() + "/major");
		
	}
}
