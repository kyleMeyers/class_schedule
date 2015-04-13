package classSchedule;

import classSchedule.model.Course;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.IDatabase;

public class ClassController {
	public Course findCoursebyTitleOrCrn(String courseName, String crn) {
		IDatabase db = DatabaseProvider.getInstance();		//base courseName information and getting it from the database

		return db.findCoursebyTitleOrCrn(courseName, crn);			//returns the database information
	}

}
