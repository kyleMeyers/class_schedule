package classSchedule.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classSchedule.controllerSchedule;
import classSchedule.modelSchedule;
import classSchedule.model.User;

public class ClassScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/schedule.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		modelSchedule model = new modelSchedule();

		controllerSchedule controller = new controllerSchedule();
		controller.setModel(model);	//should change to a setModel for a setter after code is done in controller
		
		if (req.getParameter("startApp") != null) {
			controller.startApp();
		} else {
			// Reconstruct current modelSchedule model object
			User curUser = getUse(req, "userNa");
			//User tempUser = new User(902, "Bob", "horse");
			
			model.setUser(curUser);
			//model.setUser(tempUser);
			
			if (req.getParameter("gotIt") != null) {
				controller.setUserFound();
			} else if (req.getParameter("not") != null) {
				controller.setEnterUsernameAgain();
			} else {
				throw new ServletException("Unknown command");
			}
		}
		
		req.setAttribute("app", model);		// Throws PropertyNotFound Exception; model is missing ID property
		
		//req.getRequestDispatcher("/_view/schedule.jsp").forward(req, resp);
	}

	private User getUse(HttpServletRequest req, String name) {
		return null;
		//return String.parseString(req.getParameter(name));
	}

	/*private int getMajor(HttpServletRequest req, String name) {
		return Integer.parseInt(req.getParameter(name));
	}*/
}
