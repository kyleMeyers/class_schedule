package classSchedule;

import java.util.ArrayList;
import java.util.List;


public class Major {
	
	private String name;
	private boolean isMinor;
	private List<Course> requirements;
	private String description;
	
	public Major (String name, boolean isMinor, String description)
	{
		this.name = name;
		this.isMinor = isMinor;
		this.requirements = new ArrayList<Course>();
		this.description = description;
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
	
	//Return the name of the string
	public String getDescription()
	{
		return description;
	}
	
	//Set the name of the major
	public void setDescription(String description)
	{
		this.description = description;
	}

}
