package classSchedule;

import classSchedule.model.Major;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.IDatabase;

public class MajorController {

	public Major findMajor(String major) {
		IDatabase db = DatabaseProvider.getInstance();		//base major information and getting it from the database

		return db.findMajor(major);			//returns the database information
	}
	
	public void newUser(String username, String password, String major)
	{
		IDatabase db = DatabaseProvider.getInstance();
		
		db.newUser(username, password, major);
		return;
	}

}
