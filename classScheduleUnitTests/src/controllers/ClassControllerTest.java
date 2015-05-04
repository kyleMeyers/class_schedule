package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.ClassController;
import classSchedule.model.Course;
import classSchedule.model.Major;
import classSchedule.model.User;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.FakeDatabase;

public class ClassControllerTest {
	private User initUser, newUser;
	private Major initMajor, newMajor;
	private ClassController control;
	
	private User aUser;
	
	@Before
	public void setUp() {
		FakeDatabase db = new FakeDatabase();
		DatabaseProvider.setInstance(db);
		control = new ClassController();
		
		initUser = new User();
		newUser = new User();
		initMajor = new Major();
		newMajor = new Major();
		
		initMajor.setName("Math");
		initUser.setUsername("Meyers");
		initUser.setPassword("test1");
		initUser.setMajor(initMajor.getName());

		newMajor.setName("Fun");
		newUser.setUsername("Bob");
		newUser.setPassword("fail");
		newUser.setMajor(newMajor.getName());
		
		aUser = db.findUser("Coover", "test3"); // part of the initial data
	}
	
	@Test
	public void testFindCourseByMajor() throws Exception {
		Major tester = new Major();
		Course exists = new Course();
		tester.setName("Computer Science");
		exists.setName("Ghosts in the Machine");
		assertNotNull(control.findCourseByMajor(tester));
	}
	
	@Test
	public void testFindMajorByUser() throws Exception {
		User not_a_user = new User();
		assertNull(control.findMajorByUser(not_a_user));
		assertNotNull(control.findMajorByUser(aUser));
	}

}
