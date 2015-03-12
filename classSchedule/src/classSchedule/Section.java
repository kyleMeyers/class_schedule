package classSchedule;

public class Section {
	private Professor instructor;
	private String date;
	private int CRN;
	
	/**
	 * Constructor
	 * @param instructor Professor for the section
	 * @param date Meeting time (Include day(s) of week AND time of day?)
	 * @param CRN Section number
	 * @param TBD a course number
	 */
	public Section(Professor instructor, String date, int crn) {
		this.setInstructor(instructor);
		this.setDate(date);
		this.setCRN(crn);
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
	
	public int getCRN() {
		return CRN;
	}
	
	public void setCRN(int crn) {
		this.CRN = crn;
	}
}
