package classSchedule.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import classSchedule.model.Course;
import classSchedule.model.IdRelation;
import classSchedule.model.Major;
import classSchedule.model.Professor;
import classSchedule.model.User;

public class InitialData {
	
	//reads the users in the csv spreadsheet for the fakeDatabase
	public static List<User> getUsers() throws IOException{
		List<User> userList = new ArrayList<User>();
		ReadCSV readUsers = new ReadCSV("users.csv");
		
		try {
			while (true) {
				List<String> tuple = readUsers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				User user = new User();
				user.setId(Integer.parseInt(i.next()));
				user.setUsername(i.next());
				user.setPassword(i.next());
				userList.add(user);
			}
			return userList;
		} finally {
			readUsers.close();
		}
	}
	
	//reads in the majors in the csv spreadsheet for the fakeDatabase
	public static List<Major> getMajors() throws IOException{
		List<Major> majorList = new ArrayList<Major>();
		ReadCSV readMajors = new ReadCSV("majors.csv");
		
		try {
			while (true) {
				List<String> tuple = readMajors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Major major = new Major();
				major.setId(Integer.parseInt(i.next()));
				major.setName(i.next());
				majorList.add(major);
			}
			return majorList;
		} finally {
			readMajors.close();
		}
	}
	
	//reads in the courses in the csv spreadsheet for the fakeDatabase
		public static List<Course> getCourses() throws IOException{
			List<Course> courseList = new ArrayList<Course>();
			ReadCSV readCourses = new ReadCSV("classes.csv");
			
			try {
				while (true) {
					List<String> tuple = readCourses.next();
					if (tuple == null) {
						break;
					}
					Iterator<String> i = tuple.iterator();
					Course course = new Course();
					course.setId(Integer.parseInt(i.next()));
					course.setCRN(i.next());
					course.setName(i.next());
					courseList.add(course);
				}
				return courseList;
			} finally {
				readCourses.close();
			}
		}
		public static List<Professor> getProfessors() throws IOException{
			List<Professor> professorList = new ArrayList<Professor>();
			ReadCSV readProfessors = new ReadCSV("professors.csv");
			
			try {
				while (true) {
					List<String> tuple = readProfessors.next();
					if (tuple == null) {
						break;
					}
					Iterator<String> i = tuple.iterator();
					Professor professor = new Professor();
					professor.setID(Integer.parseInt(i.next()));
					professor.setFirstName(i.next());
					professor.setLastName(i.next());
					professorList.add(professor);
				}
				return professorList;		
			} finally {
				readProfessors.close();
			}
		}
		
		public static List<IdRelation> getMajorCourses() throws IOException{
			List<IdRelation> majorCourseList = new ArrayList<IdRelation>();
			ReadCSV readMajorCourses = new ReadCSV("majorCourses.csv");
			
			try {
				while (true) {
					List<String> tuple = readMajorCourses.next();
					if (tuple == null) {
						break;
					}
					Iterator<String> i = tuple.iterator();
					IdRelation majorCourse = new IdRelation();
					majorCourse.setId1(Integer.parseInt(i.next()));
					majorCourse.setId2(Integer.parseInt(i.next()));
					majorCourseList.add(majorCourse);
				}
				return majorCourseList;		
			} finally {
				readMajorCourses.close();
			}
		}
		
		public static List<IdRelation> getUserMajors() throws IOException{
			List<IdRelation> userMajorList = new ArrayList<IdRelation>();
			ReadCSV readUserMajors = new ReadCSV("userMajors.csv");
			
			try {
				while (true) {
					List<String> tuple = readUserMajors.next();
					if (tuple == null) {
						break;
					}
					Iterator<String> i = tuple.iterator();
					IdRelation userMajor = new IdRelation();
					userMajor.setId1(Integer.parseInt(i.next()));
					userMajor.setId2(Integer.parseInt(i.next()));
					userMajorList.add(userMajor);
				}
				return userMajorList;		
			} finally {
				readUserMajors.close();
			}
		}
	}

