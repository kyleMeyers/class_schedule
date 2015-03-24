package classSchedule.model;

public class Professor {
	private String firstName;
	private String lastName;
	
	public Professor(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
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
	


}
