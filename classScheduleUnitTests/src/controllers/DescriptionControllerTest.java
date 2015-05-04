package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classSchedule.DescriptionController;
import classSchedule.model.Course;
import classSchedule.model.Description;
import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.FakeDatabase;

public class DescriptionControllerTest {

	private DescriptionController control;
	private Course course;
	private Course course2;
	
	@Before
	public void setUp() {
		FakeDatabase db = new FakeDatabase();
		DatabaseProvider.setInstance(db);
		control = new DescriptionController();
		
		//course that exists
		course.setName("Ghosts in the Machines");
		course.setId(1);
		
		//course that doesn't exist
		course2.setName("Intro to Underwater Basket Weaving");
		course2.setId(999);
	}
	@Test
	public void findDescriptionByCourse() {
		//course that exists returns the description
		Description desc = new Description();
		desc=control.findDescriptionByCourse(course);
		assertEquals(desc, "A wonderful lengthy description for this course");
		
		//course that doesn't exist returns null
		Description desc2 = new Description();
		desc2=control.findDescriptionByCourse(course);
		assertNull(desc2);
	}

}
