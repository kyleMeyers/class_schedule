package classSchedule;
/*
 * Adds classes, majors, minors, and courses 
 * to the empty modelSchedule as placeholders
 * Takes the courses and major from their 
 * respective classes and uses them in the view and model
 */
public class controllerSchedule {

	public void initModel(modelSchedule model)
	{
		Course course1 = new Course("Yay this is the course", "CS", new Section(
				new Professor("Dave", "Hovemeyer"), "MWF", 345763));
		model.getSched().add(course1);
	}

	
}
