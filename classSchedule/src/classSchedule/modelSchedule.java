package classSchedule;

//import java.util.ArrayList;

//import classSchedule.model.Course;
import classSchedule.model.Major;
import classSchedule.model.User;

public class modelSchedule {

	//private ArrayList<Course> sched;
	private Major major;
	private User user;
	
	public modelSchedule()
	{
		//sched = new ArrayList<Course>();
	}
	
	/*public ArrayList<Course> getSched()
	{
		return sched;
	}*/

	public Major getMajor()
	{
		return this.major;
	}
	
	public void setMajor(Major major)
	{
		this.major = major;
	}

	public void setUser(User curUser) {
		this.user = curUser;
		
	}

	public User getUser() {
		
		return this.user;
	}
	
	public boolean isDone() {
		return user == user;	//What user to make it equal to?
	}
	
	
	
	


}
