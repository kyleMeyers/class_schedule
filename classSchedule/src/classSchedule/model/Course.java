package classSchedule.model;

public class Course {
	
	/**
	 * Need a way to designate Course as belonging to
	 * a Major (possibly more than 1 Major).
	 */
	private int id;
	private String courseID;
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

	public int getID() {
		return id;
	}

	public void setID(int iD) {
		this.id = iD;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
}
