package classSchedule;

public class Professor {
	private String firstName;
	private String lastName;
	private String description;
	
	public Professor(String firstName, String lastName, String description)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
	}
	
	/**
	 * @return A professor's {@link firstName}
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName Set professor's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return A professor's {@link lastName}
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName Set professor's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return A professor's {@link description}
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description Set professor's description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

}
