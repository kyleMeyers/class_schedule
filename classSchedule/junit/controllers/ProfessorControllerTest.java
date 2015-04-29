package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.ProfessorController;
import classSchedule.model.Professor;

public class ProfessorControllerTest {

	private Professor prof;
	private Professor prof2;
	private ProfessorController control;
	
	@Before
	public void setUp() {
		prof = new Professor();
		prof.setFirstName("David");
		prof.setLastName("Hovemeyer");
		
		prof2 = new Professor();
		prof2.setFirstName("No");
		prof2.setLastName("Name");
	}
	
	@Test
	public void testFindProfessor() {
		
		Professor found = new Professor();
		found = control.findProfessor(prof.getFirstName(), prof.getLastName());
		assertEquals(prof.getFirstName(), found.getFirstName());
		assertEquals(prof.getLastName(), found.getLastName());
		
		found = control.findProfessor(prof2.getFirstName(), prof2.getLastName());
		assertFalse(prof2.getFirstName()==found.getFirstName());
		assertFalse(prof2.getLastName()==found.getLastName());
	}

}
