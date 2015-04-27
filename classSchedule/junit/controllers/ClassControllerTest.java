package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.model.Major;
import classSchedule.model.User;

public class ClassControllerTest {

	@Before
	public void setUp() {
		User initUser = new User();
		User newUser = new User();
		Major initMajor = new Major();
		Major newMajor = new Major();
		
		initMajor.setMajorID("Math");
		initUser.setUsername("Meyers");
		initUser.setPassword("test1");
		initUser.setMajor(initMajor.getName());
		
		newUser.setUsername("Bob");
		newUser.setPassword("fail");
		newMajor.setName("Fun");
	}
	
	@Test
	public void testFindCourseByMajor() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFindMajorByUser() {
		fail("Not yet implemented");
	}

}
