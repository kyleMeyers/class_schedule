package classSchedule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.model.Course;
import classSchedule.model.Professor;
import classSchedule.model.Section;

public class CourseTest {
	private Course myCourse;
	private Professor myProfessor;
	private Section mySection;
	private Section newSection;
	
	@Before
	public void setUp() throws Exception {
		myProfessor = new Professor("David", "Hovemeyer");
		mySection = new Section(myProfessor, "TR", 10135, 101);
		newSection = new Section(myProfessor, "WF", 10130, 320);
		//myCourse = new Course("Programming Language Design", "CS340", mySection);
	}
	
	@Test
	public void test() {
		//test get methods
		/*assertEquals("Programming Language Design", myCourse.getDescription());
		assertEquals("CS340", myCourse.getPrefix());
		assertEquals("TR", myCourse.getSection().getDate());
		assertEquals(10135, myCourse.getSection().getCRN());
		
		//test set methods
		myCourse.setDescription("Fundamentals of Computer Science II");
		assertEquals("Fundamentals of Computer Science II", myCourse.getDescription());
		myCourse.setPrefix("CS201");
		assertEquals("CS201", myCourse.getPrefix());
		myCourse.setSection(newSection);
		assertEquals("WF", myCourse.getSection().getDate());
		assertEquals(10130, myCourse.getSection().getCRN());*/
	}

}
