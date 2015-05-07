package classSchedule;


import classSchedule.model.Course;
import classSchedule.model.Description;
import classSchedule.model.IdRelation;
import classSchedule.model.User;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.IDatabase;

public class DescriptionController {
	
	public Description findDescriptionByCourse(Course cour)
	{
		IDatabase db = DatabaseProvider.getInstance();
		
		return db.findDescriptionByCourse(cour);
	}
	
	public IdRelation storeCoursesForUsers(User user, Course course)
	{
		IDatabase db = DatabaseProvider.getInstance();
		
		return db.storeCoursesForUsers(user, course);
	}
}
