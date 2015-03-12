package classSchedule;

import java.util.List;


public class major {
	
	private String name;
	private boolean isMinor;
	private List <Course> requirements;
	
	public major (String name, boolean isMinor, List <Course> requirements)
	{
		this.name = name;
		this.isMinor = isMinor;
		this.requirements = requirements;
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
	
	public List <Course> getRequirements ()
	{
		return requirements;
	}

}
