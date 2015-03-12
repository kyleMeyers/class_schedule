package classSchedule;

import java.util.List;

public class Course {
	private List<String> Description;
	private String Prefix;
	private Section section;
	
	/**
	 * Constructor
	 * @param description TBD
	 * @param prefix Course category (i.e., CHM for Chemistry)
	 * @param section Section description
	 */
	public Course(List<String> description, String prefix, Section section) {
		this.setDescription(description);
		this.setPrefix(prefix);
		this.setSection(section);
	}
	
	/**
	 * Getters and Setters for course fields
	 */
	public List<String> getDescription() {
		return Description;
	}

	public void setDescription(List<String> description) {
		this.Description = description;
	}

	public String getPrefix() {
		return Prefix;
	}

	public void setPrefix(String prefix) {
		this.Prefix = prefix;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
}
