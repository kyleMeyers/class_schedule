package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.MajorController;
import classSchedule.model.User;
import classSchedule.model.Major;

public class MajorControllerTest {

	private User user;
	private Major major;
	private MajorController control;
	
	@Before
	public void setUp() {
		user = new User();
		user.setUsername("Schmedding");
		user.setPassword("test4");
		major = new Major();
		major.setName("Computer Science");
	}
	
	@Test
	public void testFindMajor() {
		
		Major found = new Major();
		found = control.findMajor(major.getName());
		assertEquals(major.getName(), found.getName());
		
		found = control.findMajor("Underwater Basket Weaving");
		assertFalse(found.getName()=="Underwater Basket Weaving");
	}
	@Test
	public void testNewUser() {
		fail("Not yet implemented");
		//how
	}
	
	@Test
	public void testFindMajorForUser() {
		Major found = new Major();
		found = control.findMajorForUser(user);
		assertEquals(major.getName(), found.getName());
	}
	
	@Test
	public void testStoreMajorForUser() {
		fail("Not yet implemented");
		//how
	}

}
