package classSchedule;

import classSchedule.model.IdRelation;
import classSchedule.model.Major;
import classSchedule.model.User;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.IDatabase;

public class MajorController {

	public Major findMajor(String major) {
		IDatabase db = DatabaseProvider.getInstance();		//base major information and getting it from the database

		return db.findMajor(major);			//returns the database information
	}
	
	public void newUser(String username, String password)
	{
		IDatabase db = DatabaseProvider.getInstance();
		
		db.newUser(username, password);
		return;
	}

	public Major findMajorForUser(User user) {
		IDatabase db = DatabaseProvider.getInstance();
		return db.findMajorByUser(user);
	}

	public IdRelation storeMajorForUser(User user, Major major) {
		// TODO Auto-generated method stub
		//take the user and major id and insert a tuple with both of those in them
		IDatabase db = DatabaseProvider.getInstance();
		
		return db.storeMajorForUser(user, major);
	}

}
