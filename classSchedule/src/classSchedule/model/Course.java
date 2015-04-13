package classSchedule.model;

public class Course {

	private int id;
	private String crn;
	private String name;
	
	public Course()
	{
		
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getCRN()
	{
		return crn;
	}
	
	public void setCRN(String crn)
	{
		this.crn = crn;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
