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
			if((userList.contains(username) && userList.contains(password)) || (userList.contains(id) && userList.contains(password)))
			{
				return new User(username, password, id);
			}
			else
			{
				return new User("Invalid Username", "Invalid Password", 0000);
			}
	}

	@Override
	public Major findMajor(String major, boolean isMinor) {
		// TODO Auto-generated method stub
		return null;
	}
}
