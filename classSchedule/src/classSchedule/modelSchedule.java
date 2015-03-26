package classSchedule;

import java.util.ArrayList;

import classSchedule.model.Course;
import classSchedule.model.Major;
import classSchedule.model.User;

public class modelSchedule {

	private ArrayList<Course> sched;
	private Major major;
	
	public modelSchedule()
	{
		sched = new ArrayList<Course>();
	}
	
	public ArrayList<Course> getSched()
	{
		return sched;
	}
	
	public Major getMajor()
	{
		return this.major;
	}
	
	public void setMajor(Major major)
	{
		this.major = major;
	}

	public User getUser() {
		return null;	//TODO: Actually get the user 
	}

}
