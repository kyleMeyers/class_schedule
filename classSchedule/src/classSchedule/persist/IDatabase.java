package classSchedule.persist;

import java.util.List;

import classSchedule.model.Major;
import classSchedule.model.User;

public interface IDatabase {
	// Persistence operations are defined here
	
	public User findUser(String username, String password, int id);
	
	public Major findMajor(String major, boolean isMinor);

}
