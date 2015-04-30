package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.MajorController;
import classSchedule.model.User;
import classSchedule.model.Major;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.FakeDatabase;

public class MajorControllerTest {

	private User user;
	private Major major;
	private MajorController control;
	
	@Before
	public void setUp() {
		FakeDatabase db = new FakeDatabase();
		DatabaseProvider.setInstance(db);
		control = new MajorController();
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
		
		assertNull(control.findMajor("Underwater Basket Weaving"));
		assertNotNull(control.findMajor(major.getName()));
	}
	@Test
	public void testNewUser() {
		User newGuy = new User();
		newGuy.setUsername("Billy");
		newGuy.setPassword("trains");
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
