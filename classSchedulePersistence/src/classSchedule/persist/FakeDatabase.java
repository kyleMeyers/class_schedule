package classSchedule.persist;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classSchedule.model.Course;
import classSchedule.model.Description;
import classSchedule.model.IdRelation;
import classSchedule.model.Major;
import classSchedule.model.Professor;
import classSchedule.model.User;

public class FakeDatabase implements IDatabase {
	private List<User> userList;
	private List<Course> courseList;
	private List<Professor> professorList;
	private List<Major> majorList;
	private List<Description> descList;
	private List<IdRelation> majorUsersList;
	private List<IdRelation> coursesMajorsList;


	public FakeDatabase() {
		userList = new ArrayList<>();
		courseList = new ArrayList<>();
		professorList = new ArrayList<>();
		majorList = new ArrayList<>();
		descList = new ArrayList<>();
		majorUsersList = new ArrayList<>();
		coursesMajorsList = new ArrayList<>();

		readInitialData();

	}
	//reads the data from the files for each list
	public void readInitialData() {
		try {
			userList.addAll(InitialData.getUsers());
			majorList.addAll(InitialData.getMajors());
			courseList.addAll(InitialData.getCourses());
			professorList.addAll(InitialData.getProfessors());
			descList.addAll(InitialData.getDescriptions());
			majorUsersList.addAll(InitialData.getUserMajors());
			coursesMajorsList.addAll(InitialData.getMajorCourses());
			
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
			if(maj.getName().equalsIgnoreCase(major))
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
	
	// Returns the single course specified (by Name)
	@Override
	public Course findCoursebyTitleOrCrn(String courseName, String crn) {
		for(Course cour : courseList)
		{
			if (cour.getName() == courseName || cour.getCRN() == crn)
			{
				Course courseResult = findCourseById(cour.getId());	// Gets current matching course from id in csv
				return courseResult;
			}
		}

		return null;
	}
	private Course findCourseById(int id) {
		for(Course core: courseList)
		{
			if(core.getId() == id)
			{
				return core;
			}
		}
		return null;
	}
	
	// Adds a new user to the userList (if not yet in the list)
	@Override
	public User newUser(String username, String password) {
		User temp = new User();
		temp.setUsername(username);
		temp.setPassword(password);
		
		if (!userList.contains(temp.getUsername()) && !userList.contains(temp.getPassword()))
		{
			return temp;
		}
		
		return null;
	}
	@Override
	public List<Course> findCourseByMajor(Major major) {
		
		List<Course> result = new ArrayList<Course>();
		
		for(IdRelation courMaj : coursesMajorsList)
		{
			while(courMaj.getId1() == major.getId())
			{
				Course courseResult = findCourseById(courMaj.getId2());	// Gets current matching course from id in csv
				result.add(courseResult);
			}
		}
		return result;
	}
	@Override
	public Major findMajorByUser(User use) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IdRelation storeMajorForUser(User user, Major major) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Description findDescriptionByCourse(Course cour) {
		// TODO Auto-generated method stub
		return null;
	}
}

