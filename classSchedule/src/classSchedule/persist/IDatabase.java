package classSchedule.persist;

import java.util.List;
import classSchedule.model.Course;
import classSchedule.model.Description;
import classSchedule.model.IdRelation;
import classSchedule.model.Major;
import classSchedule.model.Professor;
import classSchedule.model.User;

public interface IDatabase {
	// Persistence operations are defined here

	public User findUser(String username, String password);

	public Professor findProfessor(String firstname, String lastname);
	
	//TODO: make a new User login function and then have it insert that new user into the database
	public User newUser(String username, String password);
	
	public Major findMajor(String major);

	public Course findCoursebyTitle(String courseName);
	
	public Major findMajorByUser(User use);

	public List<Course> findCourseByMajor(Major major);

	public IdRelation storeMajorForUser(User user, Major major);

	public Description findDescriptionByCourse(Course cour);

}
