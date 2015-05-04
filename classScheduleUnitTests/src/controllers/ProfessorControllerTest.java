package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.ProfessorController;
import classSchedule.model.Professor;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.FakeDatabase;

public class ProfessorControllerTest {

	private Professor prof;
	private Professor prof2;
	private ProfessorController control;
	
	@Before
	public void setUp() {
		FakeDatabase db = new FakeDatabase();
		DatabaseProvider.setInstance(db);
		control = new ProfessorController();
		
		//professor that exists in fake database
		prof = new Professor();
		prof.setFirstName("Dave");
		prof.setLastName("Hovemeyer");
		
		//professor that doesn't exist in fake database
		prof2 = new Professor();
		prof2.setFirstName("No");
		prof2.setLastName("Name");
	}
	
	@Test
	public void testFindProfessor() {
		
		//Professor that exists in fake database should return same first and last name
		Professor found = new Professor();
		found = control.findProfessor(prof.getFirstName(), prof.getLastName());
		assertEquals(prof.getFirstName(), found.getFirstName());
		assertEquals(prof.getLastName(), found.getLastName());
		
		//Professor that doesn't exist in fake database should return null
		Professor found2 = new Professor();
		found2 = control.findProfessor(prof2.getFirstName(), prof2.getLastName());
		assertNull(found2.getFirstName());
		assertNull(found2.getLastName());
	}

}
