package classSchedule.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import classSchedule.model.Major;
import classSchedule.model.User;

public class FakeDatabase implements IDatabase {
	private List<User> userList;
	private List<Major> majorList;
	
	public FakeDatabase() {
		userList = new ArrayList<>();
		majorList = new ArrayList<>();
		// TODO: add some  test users
		
		readInitialData();
	}
	public void readInitialData() {
		try {
			userList.addAll(InitialData.getUsers());
			majorList.addAll(InitialData.getMajors());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	@Override
	public User findUser(String username, String password, int id) {
			User result = new User();
			for(User use: userList)
			{
				if(use.getPassword().equals(password) && use.getUsername().equals(username))
				{
					User userResult = findUserById(use.getId());
					result = userResult;
					
				}
			}
			
			return result;
	}

	private User findUserById(int id) {
		for(User use: userList)
		{
			if(use.getId() == id)
			{
				return use;
			}
		}
		return null;
	}
	@Override
	public Major findMajor(String major, boolean isMinor) {
		// TODO Auto-generated method stub
		return null;
	}
}
