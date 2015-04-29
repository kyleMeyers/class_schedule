package classSchedule;

import java.util.List;

import classSchedule.model.Course;
import classSchedule.model.Major;
import classSchedule.model.User;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.IDatabase;

public class ClassController {
	public List<Course> findCourseByMajor(Major major) {
		IDatabase db = DatabaseProvider.getInstance();		//base courseName information and getting it from the database

		return db.findCourseByMajor(major);			//returns the database information
	}
	
	public Major findMajorByUser(User use)
	{
		IDatabase db = DatabaseProvider.getInstance();
		
		return db.findMajorByUser(use);
	}

}
