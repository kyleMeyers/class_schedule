package classSchedule.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.FakeDatabase;

public class DatabaseInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent e) {
		// Create a database provider object
		System.out.println("Initializing database!");
		DatabaseProvider.setInstance(new FakeDatabase()); // TDOO: eventually use a real database
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		// TODO Auto-generated method stub

	}

}
