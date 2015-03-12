package classSchedule;

public class Course {
	private String Description;
	private String Prefix;
	private int Section;
	
	public void course(String Description, String Prefix, int Section) {
		this.setDescription(Description);
		this.setPrefix(Prefix);
		this.setSection(Section);
	}
	
	/**
	 * Getters and Setters for course fields
	 */
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPrefix() {
		return Prefix;
	}

	public void setPrefix(String prefix) {
		Prefix = prefix;
	}

	public int getSection() {
		return Section;
	}

	public void setSection(int section) {
		Section = section;
	}
}
