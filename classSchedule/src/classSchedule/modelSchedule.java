package classSchedule;

import java.util.ArrayList;

/*
 * Model creates an initial blank schedule
 * of major, minor, courses and puts it into a blank schedule
 */
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
}
