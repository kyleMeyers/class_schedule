package classSchedule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SectionTest {
	private Professor myProfessor;
	private Professor changedProfessor;

	private Section mySection;
	
	@Before
	public void setUp() throws Exception {
		myProfessor = new Professor("David", "Hovemeyer", "desc");
		changedProfessor = new Professor("James", "Moscola", "desc2");
		mySection = new Section(myProfessor, "TR", 10135);
	}
	
	@Test
	public void test() {
		//test get methods
		assertEquals(myProfessor.getLastName(), mySection.getInstructor().getLastName());
		assertEquals(myProfessor.getFirstName(), mySection.getInstructor().getFirstName());
		assertEquals(myProfessor.getDescription(), mySection.getInstructor().getDescription());
		assertEquals("TR", mySection.getDate());
		assertEquals(10135, mySection.getCRN());
		
		//test set methods
		mySection.setInstructor(changedProfessor);
		assertEquals(changedProfessor.getLastName(), mySection.getInstructor().getLastName());
		assertEquals(changedProfessor.getFirstName(), mySection.getInstructor().getFirstName());
		assertEquals(changedProfessor.getDescription(), mySection.getInstructor().getDescription());
		mySection.setCRN(10140);
		assertEquals(10140, mySection.getCRN());
		mySection.setDate("MWF");
		assertEquals("MWF", mySection.getDate());
	}

}
