package classSchedule.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import classSchedule.model.Course;
import classSchedule.model.Major;
import classSchedule.model.Professor;
import classSchedule.model.User;

public class FakeDatabase implements IDatabase {
	private List<User> userList;
	//private List<Course> courseList;
	private List<Professor> professorList;
	private List<Major> majorList;


	public FakeDatabase() {
		userList = new ArrayList<>();
		//courseList = new ArrayList<>();
		professorList = new ArrayList<>();
		majorList = new ArrayList<>();

		readInitialData();

	}
	//reads the data from the files for each list
	public void readInitialData() {
		try {
			userList.addAll(InitialData.getUsers());
			majorList.addAll(InitialData.getMajors());
			//TODO: add course and professor lists
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	@Override
	//finds the user with the username and password and returns the id
	//TODO:? may want to return the username if given the id
	//Kyle's rendition of the findUser implementation
	public User findUser(String username, String password) {
		for(User use : userList)
		{
			// Iterates through list of users; When current one matches given credentials (if it does),
			// create user object from current user's ID, return that user
			if (use.getPassword().equals(password) && use.getUsername().equals(username))
			{
				User userResult = findUserById(use.getId());	// Gets current matching user from this user's ID
				return userResult;
			}
		}

		return null;
	}

	private User findUserById(int id) {
		for(User use: userList)
		{
			if (use.getId() == id)
			{
				return use;
			}
		}
		return null;
	}
	@Override
	//find major will find a major from input in the database
	public Major findMajor(String major) {
		//iterates through the major list until the entered major is equal to the major in the database
		for(Major maj: majorList)
		{
			if(maj.getName().equals(major))
			{
				Major majResult = findMajorById(maj.getId());
				return majResult;
			}
		}
		
		return null;

	}
	//finds the id of the major in the database
	private Major findMajorById(int id) {
		for(Major maj: majorList)
		{
			if(maj.getId() == id)
			{
				return maj;
			}
		}
		return null;
	}
	


	@Override
	public Professor findProfessor(String firstname, String lastname) {
		for (Professor p : professorList)
		{
			if (p.getFirstName().equals(firstname) && p.getLastName().equals(lastname))
			{
				return p;
			}
		}
		return null;
	}
	@Override
	public Course findCoursebyTitle(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Course findCoursebyCRN(int cRN) {
		// TODO Auto-generated method stub
		return null;
	}

}
