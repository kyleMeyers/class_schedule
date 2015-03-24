package classSchedule;

import java.util.List;


public class Major {
	
	private String name;
	private boolean isMinor;
	private List<Course> requirements;
	
	public Major (String name, boolean isMinor)	// List<Course> requirements
	{
		this.name = name;
		this.isMinor = isMinor;
		//this.requirements = requirements;
	}
	
	//Return the name of the string
	public String getName()
	{
		return name;
	}
	
	//Set the name of the major
	public void setName(String name)
	{
		this.name = name;
	}
	
	//determine if this is a minor
	public boolean determineMinor()
	{
		return isMinor;
	}
	
	//Set if this is a minor
	public void setMinor (boolean isMinor)
	{
		this.isMinor = isMinor;
	}
	
	//Get all of the requirements for the Major/Minor
	public List <Course> getRequirements ()
	{
		return requirements;
	}
	
	public void addRequirement (Course newClass)
	{
		requirements.add(newClass);
	}

}
