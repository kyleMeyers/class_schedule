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
	private ProfessorController control;
	
	@Before
	public void setUp() {
		FakeDatabase db = new FakeDatabase();
		DatabaseProvider.setInstance(db);
		control = new ProfessorController();
		prof = new Professor();
		prof.setFirstName("David");
		prof.setLastName("Hovemeyer");
	}
	
	@Test
	public void testFindProfessor() {
		
		Professor found = new Professor();
		found = control.findProfessor(prof.getFirstName(), prof.getLastName());
		assertEquals(prof.getFirstName(), found.getFirstName());
		assertEquals(prof.getLastName(), found.getLastName());
	}

}
