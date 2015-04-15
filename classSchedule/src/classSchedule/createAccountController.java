package classSchedule;

import classSchedule.model.User;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.IDatabase;

public class createAccountController {
	public User findUser(String username, String password) {
		IDatabase db = DatabaseProvider.getInstance();		//base login information and getting it from the database
		
		return db.findUser(username, password);				//returns the database information
	}
	
}