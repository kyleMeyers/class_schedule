package classSchedule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProfessorTest {
	private Professor myProfessor;
	
	@Before
	public void setUp() throws Exception {
		myProfessor = new Professor("David", "Hovemeyer");
	}
	
	@Test
	public void test() {
		//test get methods
		assertEquals("David", myProfessor.getFirstName());
		assertEquals("Hovemeyer", myProfessor.getLastName());
		
		//test set methods
		myProfessor.setFirstName("James");
		myProfessor.setLastName("Moscola");
		assertEquals("James", myProfessor.getFirstName());
		assertEquals("Moscola", myProfessor.getLastName());
	}

}
