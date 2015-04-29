package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.LoginController;
import classSchedule.model.User;

public class LoginControllerTest {

	private User user;
	private LoginController control;
	
	@Before
	public void setUp() {
		user = new User();
		user.setUsername("Schmedding");
		user.setPassword("test4");
	}
	
	@Test
	public void testFindProfessor() {
		
		User found = new User();
		found = control.findUser(user.getUsername(), user.getPassword());
		assertEquals(user.getUsername(), found.getUsername());
		assertEquals(user.getPassword(), found.getPassword());
	}

}
