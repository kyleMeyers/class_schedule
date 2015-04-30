package classSchedule.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DescriptionServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			req.getRequestDispatcher("/_view/courseDescription.jsp").forward(req, resp);
		}

		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
			
			//TODO: if button pressed to either add to done list or to do for scheduling list then make them go back to
			//class.jsp to pick out another class
			
			return;
		}
}
