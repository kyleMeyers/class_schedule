package classSchedule;


import classSchedule.model.Course;
import classSchedule.model.Description;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.IDatabase;

public class DescriptionController {
	
	public Description findDescriptionByCourse(Course cour)
	{
		IDatabase db = DatabaseProvider.getInstance();
		
		return db.findDescriptionByCourse(cour);
	}
}
