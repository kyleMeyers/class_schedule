package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.ClassController;
import classSchedule.model.Major;
import classSchedule.model.User;

public class ClassControllerTest {
	private User initUser, newUser;
	private Major initMajor, newMajor;
	private ClassController control;
	
	@Before
	public void setUp() {
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
	}
	
	@Test
	public void testFindCourseByMajor() throws Exception {
		assertEquals(initMajor.getName(), control.findMajorByUser(initUser).getName());
	}
	
	@Test
	public void testFindMajorByUser() throws Exception {
		fail("Not yet implemented");
	}

}
