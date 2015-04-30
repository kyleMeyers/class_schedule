package classSchedule.model;

public class Course {
	
	/**
	 * Need a way to designate Course as belonging to
	 * a Major (possibly more than 1 Major).
	 */
	private int id;
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
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

}
