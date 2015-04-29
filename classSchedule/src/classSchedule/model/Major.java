package classSchedule.model;

public class Major {
	
	private int id;
	private String MajorID;
	private String name;
	//private List<Course> requirements;
	
	public Major ()
	{
		
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
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}

	public String getMajorID() {
		return MajorID;
	}

	public void setMajorID(String majorID) {
		MajorID = majorID;
	}

}
