package classSchedule.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classSchedule.model.Course;
import classSchedule.model.Major;
import classSchedule.model.Professor;
import classSchedule.model.User;



public class SqliteDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load sqlite driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	//TODO: Add an sql database entry for finding the user from the login information
	@Override
	public User findUser(String username, String password) {
		return executeTransaction(new Transaction<User>() {
			@Override
			public User execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select users.* " +			//the entire user tuple
							"  from users " +
							" where users.username = ? and users.password = ?"
					);
					stmt.setString(1, username);
					stmt.setString(2, password);
					
					User result = null;
					
					resultSet = stmt.executeQuery();
					if (resultSet.next()) { // query will produce at most 1 user or null if it does not exist
						result = new User();
						loadUser(result, resultSet, 1);
					}
					
					return result;			//returns an actual user or null if there is not one
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}
	
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
		
		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	

	private void loadUser(User user, ResultSet resultSet, int i) throws SQLException{
		user.setId(resultSet.getInt(i++));
		user.setUsername(resultSet.getString(i++));
		user.setPassword(resultSet.getString(i++));	
	}
	
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				
				try {
					stmt1 = conn.prepareStatement(
							"create table users (" +
							"    id integer primary key," +
							"    user varchar(25)," +
							"    password varchar(50)," +
							")");
					stmt1.executeUpdate();
					
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
				}
			}
		});
	}
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<User> userList;
				
				try {
					userList = InitialData.getUsers();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertUser = null;

				try {
					insertUser = conn.prepareStatement("insert into users values (?, ?, ?)");
					for (User use : userList) {
						insertUser.setInt(1, use.getId());
						insertUser.setString(2, use.getUsername());
						insertUser.setString(3, use.getPassword());
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertUser);
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		SqliteDatabase db = new SqliteDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Success!");
	}

	

	@Override
	public Course findCoursebyTitle(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findCoursebyCRN(int CRN) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor findProfessor(String firstname, String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Major findMajor(String major) {
		// TODO Auto-generated method stub
		return null;
	}
}
