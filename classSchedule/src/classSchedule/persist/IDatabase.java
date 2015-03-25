package classSchedule.persist;

import classSchedule.model.User;

public interface IDatabase {
	// Persistence operations are defined here
	
	public User findUser(String username, String password);
}
