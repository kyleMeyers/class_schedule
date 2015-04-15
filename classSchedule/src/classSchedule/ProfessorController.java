package classSchedule;

import classSchedule.model.Professor;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.IDatabase;

public class ProfessorController {

	public Professor findProfessor(String firstName, String lastName) {
		IDatabase db = DatabaseProvider.getInstance();		//base major information and getting it from the database

		return db.findProfessor(firstName, lastName);			//returns the database information
	}

}
