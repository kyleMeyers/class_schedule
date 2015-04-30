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
	
	@Before
	public void setUp() {
		FakeDatabase db = new FakeDatabase();
		DatabaseProvider.setInstance(db);
		control = new DescriptionController();
		course.setName("Ghosts in the Machines");
		course.setId(1);
	}
	@Test
	public void findDescriptionByCourse() {
		Description desc = new Description();
		desc=control.findDescriptionByCourse(course);
		assertEquals(desc, "A wonderful lengthy description for this course");
	}

}
