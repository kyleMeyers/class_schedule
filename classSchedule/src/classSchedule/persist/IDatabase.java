package classSchedule.persist;


import classSchedule.model.Course;
import classSchedule.model.Major;
import classSchedule.model.Professor;

import java.util.List;

import classSchedule.model.Major;
import classSchedule.model.User;

public interface IDatabase {
	// Persistence operations are defined here
	
	/**
	 * Find the {@link User} with the given username and password. 
	 * 
	 * @param username the username to search for
	 * @param password the user's password
	 * @return the {@link User} matching the username and password,
	 *         or null if there is no such user
	 */
	public User findUser(String username, String password);
	
	public Course findCoursebyTitle(String courseName);
	
	public Course findCoursebyCRN(int CRN);
	
	public Professor findProfessor(String firstname, String lastname);

	public Major findMajor(String major);


}
