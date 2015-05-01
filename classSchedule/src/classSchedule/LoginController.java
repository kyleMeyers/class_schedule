package classSchedule;

import classSchedule.model.User;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.IDatabase;

public class LoginController {

	public User findUser(String username, String password) {
		IDatabase db = DatabaseProvider.getInstance();		//base login information and getting it from the database
		
		return db.findUser(username, password);				//returns the database information
	}
	
	public User newUser(String username, String password) {
		IDatabase db = DatabaseProvider.getInstance();		//base login information and getting it from the database
		
		return db.newUser(username, password);				//adds the database information
	}
	
}
