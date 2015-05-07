package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.LoginController;
import classSchedule.model.User;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.FakeDatabase;

public class LoginControllerTest {

	private User user;
	private LoginController control;
	
	@Before
	public void setUp() {
		FakeDatabase db = new FakeDatabase();
		DatabaseProvider.setInstance(db);
		control = new LoginController();
		user = new User();
		user.setUsername("Schmedding");
		user.setPassword("test4");
	}
	
	@Test
	public void testFindUser() {
		User found = new User();
		found = control.findUser(user.getUsername(), user.getPassword());
		assertEquals(user.getUsername(), found.getUsername());
		assertEquals(user.getPassword(), found.getPassword());
		
		assertNull(control.findUser("no", "exists"));
		assertNotNull(control.findUser(user.getUsername(), user.getPassword()));
	}
	
	@Test
	public void testNewUser() {
		// This method also exists in MajorController. Intended?
		LoginController addUser = new LoginController();
		User newGuy = new User();
		newGuy.setUsername("Billy");
		newGuy.setPassword("trains");
		
		assertNull(addUser.findUser(newGuy.getUsername(), newGuy.getPassword()));
		control.newUser(newGuy.getUsername(), newGuy.getPassword());
		assertNotNull(addUser.findUser("Billy", "trains"));
	}

}
