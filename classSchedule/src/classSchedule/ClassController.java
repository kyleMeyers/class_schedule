package classSchedule;

import java.util.List;

import classSchedule.model.Course;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.IDatabase;

public class ClassController {
	public List<Course> findCourseByMajor(String major) {
		IDatabase db = DatabaseProvider.getInstance();		//base courseName information and getting it from the database

		return db.findCourseByMajor(major);			//returns the database information
	}

}
