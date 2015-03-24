package classSchedule.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classSchedule.controllerSchedule;
import classSchedule.modelSchedule;

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
			//Major curMaj = getMajor(req, "major");
			//Integer curMin = getInteger(req, "min");
			//Integer curMax = getInteger(req, "max");
			
			//model.setMin(curMin);
			//model.setMax(curMax);
			/*
			if (req.getParameter("gotIt") != null) {
				controller.setNumberFound();
			} else if (req.getParameter("less") != null) {
				controller.setNumberIsLessThanGuess();
			} else if (req.getParameter("more") != null) {
				controller.setNumberIsGreaterThanGuess();
			} else {
				throw new ServletException("Unknown command");
			}*/
		}
		
		req.setAttribute("app", model);
		
		req.getRequestDispatcher("/_view/schedule.jsp").forward(req, resp);
	}

	private int getMajor(HttpServletRequest req, String name) {
		return Integer.parseInt(req.getParameter(name));
	}
}
