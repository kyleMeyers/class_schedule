package classSchedule.persist;


import classSchedule.model.Course;
import classSchedule.model.Major;
import classSchedule.model.Professor;

import java.util.List;

import classSchedule.model.Major;
import classSchedule.model.User;

public interface IDatabase {
	// Persistence operations are defined here
	

	public User findUser(String username, String password);
	
	public Course findCoursebyTitle(String courseName);
	
	public Course findCoursebyCRN(int CRN);
	
	public Professor findProfessor(String firstname, String lastname);
	
	public Major findMajor(String major, boolean isMinor, int ID);


}
