package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.LoginController;
import classSchedule.MajorController;
import classSchedule.model.User;
import classSchedule.model.Major;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.FakeDatabase;

public class MajorControllerTest {

	private User isUser;
	private Major newMajor;
	private MajorController control;
	
	@Before
	public void setUp() {
		FakeDatabase db = new FakeDatabase();
		DatabaseProvider.setInstance(db);
		control = new MajorController();
		isUser = db.findUser("Coover", "test3");
		newMajor = db.findMajor("Music");
	}
	
	@Test
	public void testFindMajor() {
		assertNull(control.findMajor("Underwater Basket Weaving"));
		assertNotNull(control.findMajor(newMajor.getName()));
	}
	@Test
	public void testNewUser() {
		LoginController addUser = new LoginController();
		User newGuy = new User();
		newGuy.setUsername("Billy");
		newGuy.setPassword("trains");
		
		assertNull(addUser.findUser(newGuy.getUsername(), newGuy.getPassword()));
		control.newUser(newGuy.getUsername(), newGuy.getPassword());
		assertNotNull(addUser.findUser("Billy", "trains"));
	}
	
	@Test
	public void testFindMajorForUser() {
		assertNotNull(control.findMajorForUser(isUser));
	}
	
	@Test
	public void testStoreMajorForUser() {
		control.storeMajorForUser(isUser, newMajor);
		assertEquals(newMajor.getName(), control.findMajorForUser(isUser).getName());
	}

}
