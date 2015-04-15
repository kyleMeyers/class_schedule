package classSchedule.model;

public class Section {
	private Professor instructor;
	private String date;
	private String id;
	private Course courseInfo;
	
	
	public Section() {

		
	}
	
	/**
	 * Getters and setters
	 */
	public Professor getInstructor() {
		return instructor;
	}
	
	public void setInstructor(Professor instructor) {
		this.instructor = instructor;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public Course getCourse() {
		return courseInfo;
	}
	
	public void setCourse(Course courseInfo) {
		this.courseInfo = courseInfo;
	}
}
