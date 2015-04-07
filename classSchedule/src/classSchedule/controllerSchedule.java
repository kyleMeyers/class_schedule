package classSchedule;

import classSchedule.model.User;



public class controllerSchedule {

	private modelSchedule model;
	//private User userName;
	
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
		//User username = new User(userName.getUsername(), userName.getPassword());
	}
	

	public void setUserFound() {
		User enter = model.getUser();
		model.setUser(enter);
		
	}

	public void setEnterUsernameAgain() {
		// TODO Auto-generated method stub
		
	}
	
	// Used mostly for figuring out how jsp works
	public String concat(String name) {
		return "Your username is " + name;
	}
	
	public User getUser() {
		return model.getUser();
	}
	

	
}
