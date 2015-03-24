package classSchedule;


import javax.swing.JFrame;


public class viewSchedule extends JFrame{
	//private major majorFirst;
	private modelSchedule model;
	private controllerSchedule controller;


	public viewSchedule()
	{

	}
	//Set the model
	public void setModel(modelSchedule model) {
		this.model = model;
	}

	// Set the controller
	public void setController(controllerSchedule controller) {
		this.controller = controller;
	}

	

}

