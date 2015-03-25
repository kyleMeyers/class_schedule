package classSchedule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.model.Professor;
import classSchedule.model.Section;

public class SectionTest {
	private Professor myProfessor;
	private Professor changedProfessor;

	private Section mySection;
	
	@Before
	public void setUp() throws Exception {
		myProfessor = new Professor("David", "Hovemeyer");
		changedProfessor = new Professor("James", "Moscola");
		mySection = new Section(myProfessor, "TR", 10135, 320);
	}
	
	@Test
	public void test() {
		//test get methods
		assertEquals(myProfessor.getLastName(), mySection.getInstructor().getLastName());
		assertEquals(myProfessor.getFirstName(), mySection.getInstructor().getFirstName());
		assertEquals("TR", mySection.getDate());
		assertEquals(10135, mySection.getCRN());
		
		//test set methods
		mySection.setInstructor(changedProfessor);
		assertEquals("Moscola", mySection.getInstructor().getLastName());
		assertEquals("James", mySection.getInstructor().getFirstName());
		mySection.setCRN(10140);
		assertEquals(10140, mySection.getCRN());
		mySection.setDate("MWF");
		assertEquals("MWF", mySection.getDate());
	}

}
