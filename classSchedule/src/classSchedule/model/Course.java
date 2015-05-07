package classSchedule.model;

public class Course {
	
	/**
	 * Need a way to designate Course as belonging to
	 * a Major (possibly more than 1 Major).
	 */
	private int id;
	private String name;
	private String semester;
	
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
	
	public String getSemester()
	{
		return semester;
	}
	public void setSemester(String time)
	{
		this.semester = time;
	}
}
