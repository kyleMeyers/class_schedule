package classSchedule;

public class controllerSchedule {


	public void initModel(modelSchedule model)
	{
		Course course1 = new Course("Yay this is the course", "CS", new Section(
				new Professor("Dave", "Hovemeyer"), "MWF", 345763, 320));
		model.getSched().add(course1);
	}

	
}
