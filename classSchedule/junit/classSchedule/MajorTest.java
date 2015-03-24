package classSchedule;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import classSchedule.model.Course;
import classSchedule.model.Major;
import classSchedule.model.Professor;
import classSchedule.model.Section;

public class MajorTest {
	private Major Major1;
	private Major Minor1;
	private Course course1;
	private Course course2;
	private Course course3;
	private Professor prof1;
	private Section section1;
	private Section section2;
	private Section section3;
	private List<Course> majorCourses;
	private List<Course> minorCourses;
	
	@Before
	public void setUp() throws Exception {
		prof1 = new Professor("David", "Hovemeyer");
		section1 = new Section(prof1, "TR", 10135, 101);
		section2 = new Section(prof1, "WF", 10130, 320);
		section3 = new Section(prof1, "M", 10142, 420);
		course1 = new Course("Programming Language Design", "CS340", section1);
		course2 = new Course("Fundamentals of Computer Science II", "CS201", section2);
		course3 = new Course("Senior Software Project I", "CS481", section3);
		
		majorCourses = new ArrayList<Course>();
		majorCourses.add(course1);
		majorCourses.add(course2);
		Major1 = new Major("Computer Science", false, majorCourses);	//, majorCourses
		
		minorCourses = new ArrayList<Course>();
		minorCourses.add(course1);
		minorCourses.add(course2);
		Minor1 = new Major("Computer Science", true, majorCourses);	//, minorCourses
	}
	
	@Test
	public void test() {
		assertEquals("Computer Science", Major1.getName());
		assertEquals(true, Major1.getRequirements().equals(majorCourses));
		assertEquals(false, Major1.determineMinor());
		assertEquals(true, Minor1.determineMinor());
		
		Major1.setMinor(true);
		assertEquals(true, Major1.determineMinor());
		Major1.setMinor(false);
		
		Minor1.setName("Computer Science Minor");
		assertEquals("Computer Science Minor", Minor1.getName());
		
		Major1.addRequirement(course3);
		majorCourses.add(course3);
		assertEquals(true, Major1.getRequirements().equals(majorCourses));
	}

}
