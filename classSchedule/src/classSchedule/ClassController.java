package classSchedule;

import java.util.List;

import classSchedule.model.Course;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.IDatabase;

public class ClassController {
	public Course findCoursebyTitle(String courseName) {
		IDatabase db = DatabaseProvider.getInstance();		//base courseName information and getting it from the database

		return db.findCoursebyTitle(courseName);			//returns the database information
	}
	
	public Course findCoursebyCRN(String CRN) {
		IDatabase db = DatabaseProvider.getInstance();		//base crn information and getting it from the database

		return db.findCoursebyCRN(CRN);			//returns the database information
	}
	
	public List<Course> findCoursesbyMajor(int ID) {
		IDatabase db = DatabaseProvider.getInstance();
		
		return db.findCoursesbyMajor(ID);
	}
}
