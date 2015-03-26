package classSchedule;

import classSchedule.model.User;



public class controllerSchedule {

	private modelSchedule model;
	// Star date:Mar 25
	public void setModel(modelSchedule model)
	{
		this.model = model;
		/*Course course1 = new Course("Yay this is the course", "CS", new Section(
				new Professor("Dave", "Hovemeyer"), "MWF", 345763, 320));
		model.getSched().add(course1);*/
	}
	
	public void startApp()
	{
		System.out.println("Enter a username: ");
//		model.setMajor(new Major("Computer Science", false));
	}
	
	public void setUser() {
		User username = model.getUser();
	}

	
}
