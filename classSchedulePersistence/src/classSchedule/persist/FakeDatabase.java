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
	private List<Course> courseList;
	private List<Professor> professorList;
	private List<Major> majorList;


	public FakeDatabase() {
		userList = new ArrayList<>();

		courseList = new ArrayList<>();
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
	public User findUser(String username, String password, int id) {
		User result = new User();
		for(User use: userList)
		{
			if(use.getPassword().equals(password) && use.getUsername().equals(username))
			{
				User userResult = findUserById(use.getId());
				result = userResult;

			}
		}

		return result;
	}

	private User findUserById(int id) {
		for(User use: userList)
		{
			if(use.getId() == id)
			{
				return use;
			}
		}
		return null;
	}
	@Override
	//find major will find a major from input(?)
	//Michaels rendition of the implementation of the findMajor. Unsure which one works or does not work at this time
	public Major findMajor(String major, boolean isMinor, int ID) {
		for(Major majorindex:majorList)
		{
			if(majorindex.getName().equals(major) || majorindex.getId() == ID)
				return majorindex;
		}

		Major invalidMajor = new Major();
		invalidMajor.setId(999);
		invalidMajor.setName("Not Found");
		return invalidMajor;


	}

	@Override
	public Course findCoursebyTitle(String courseName) {		
		for(Course cour: courseList)
		{
			if(cour.getDescription().equals(courseName))
			{
				return cour;				
			}
		}

		return null;
	}

	@Override
	public Course findCoursebyCRN(int CRN) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor findProfessor(String firstname, String lastname) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
