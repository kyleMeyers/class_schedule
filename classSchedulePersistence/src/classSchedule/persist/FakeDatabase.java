package classSchedule.persist;

import java.util.ArrayList;
import java.util.List;

import classSchedule.model.User;

public class FakeDatabase implements IDatabase {
	private List<User> userList;
	
	public FakeDatabase() {
		userList = new ArrayList<>();
		// TODO: add some  test users
	}
	
	@Override
	public User findUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
