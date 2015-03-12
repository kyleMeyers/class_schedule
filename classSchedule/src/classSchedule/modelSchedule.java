package classSchedule;

import java.util.ArrayList;

public class modelSchedule {

	private ArrayList<Course> sched;
	private Major major;
	
	//Constructor
	public modelSchedule()
	{
		sched = new ArrayList<Course>();
	}
	
	public ArrayList<Course> getSched()
	{
		return sched;
	}
	
	//getter and setter for major
	public Major getMajor()
	{
		return this.major;
	}
	
	public void setMajor(Major major)
	{
		this.major = major;
	}

}
