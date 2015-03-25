package classSchedule.persist;

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
	
	public FakeDatabase() {
		userList = new ArrayList<>();
		courseList = new ArrayList<>();
		professorList = new ArrayList<>();
		// TODO: add some  test users and test courses
	}
	
	@Override
	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Course findCoursebyTitle(String courseName) {
		// TODO Auto-generated method stub
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
	public Major findMajor(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
