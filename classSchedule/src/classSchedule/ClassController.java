package classSchedule;

import classSchedule.model.Course;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.IDatabase;

public class ClassController {
	public Course findCoursebyTitle(String courseName) {
		IDatabase db = DatabaseProvider.getInstance();		//base major information and getting it from the database

		return db.findCoursebyTitle(courseName);			//returns the database information
	}
	
	public Course findCoursebyCRN(int CRN) {
		IDatabase db = DatabaseProvider.getInstance();		//base major information and getting it from the database

		return db.findCoursebyCRN(CRN);			//returns the database information
	}
}
