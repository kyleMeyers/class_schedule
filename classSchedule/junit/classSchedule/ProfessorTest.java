package classSchedule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProfessorTest {
	private Professor myProfessor;
	
	@Before
	public void setUp() throws Exception {
		myProfessor = new Professor("David", "Hovemeyer", "desc");
	}
	
	@Test
	public void test() {
		//test get methods
		assertEquals("David", myProfessor.getFirstName());
		assertEquals("Hovemeyer", myProfessor.getLastName());
		assertEquals("desc", myProfessor.getDescription());
		
		//test set methods
		myProfessor.setFirstName("James");
		myProfessor.setLastName("Moscola");
		myProfessor.setDescription("desc2");
		assertEquals("James", myProfessor.getFirstName());
		assertEquals("Moscola", myProfessor.getLastName());
		assertEquals("desc2", myProfessor.getDescription());
	}

}
