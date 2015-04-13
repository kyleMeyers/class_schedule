package classSchedule.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	@Override
	public Major findMajor(String major) {
		return executeTransaction(new Transaction<Major>() {
			@Override
			public Major execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select majors.* " +			//the entire major tuple
							"  from majors " +
							" where majors.major = ?"
					);
					stmt.setString(1, major);
					
					Major result = null;
					
					resultSet = stmt.executeQuery();
					if (resultSet.next()) { // query will produce at most 1 major or null if it does not exist
						result = new Major();
						loadMajor(result, resultSet, 1);
					}
					
					return result;			//returns an actual major or null if there is not one
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
		String home = System.getProperty("user.home");		//creates the database file in the home directory of whoever uses it
		//connects to the database from the home directory for the WebApp folder
		Connection conn = DriverManager.getConnection("jdbc:sqlite:" + home + "/classSchedule.db");	
		
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
	
	private void loadMajor(Major result, ResultSet resultSet, int i) throws SQLException{
		result.setId(resultSet.getInt(i++));
		result.setName(resultSet.getString(i++));
		
	}
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				try {
					stmt1 = conn.prepareStatement(
							"create table users (" +
							"    id integer primary key," +
							"    username varchar(25)," +
							"    password varchar(50)" +
							")");
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
							"create table majors (" +
							"	id integer primary key," +
							"	major varchar(40)" +
							")");
					stmt2.executeUpdate();
					
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<User> userList;
				List<Major> majorList;
				
				try {
					//this gets the csvs for the initial data to the SQL
					userList = InitialData.getUsers();
					majorList = InitialData.getMajors();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertUser = null;
				PreparedStatement insertMajor = null;
				
				try {
					insertUser = conn.prepareStatement("insert into users values (?, ?, ?)");
					for (User use : userList) {
						insertUser.setInt(1, use.getId());
						insertUser.setString(2, use.getUsername());
						insertUser.setString(3, use.getPassword());
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					
					insertMajor = conn.prepareStatement("Insert into majors values (?, ?)");
					for(Major maj : majorList)
					{
						insertMajor.setInt(1, maj.getId());
						insertMajor.setString(2, maj.getName());
						insertMajor.addBatch();
					}
					insertMajor.executeBatch();
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertUser);
					DBUtil.closeQuietly(insertMajor);
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
	public Professor findProfessor(String firstname, String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findCoursebyTitle(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findCoursebyCRN(int cRN) {
		// TODO Auto-generated method stub
		return null;
	}


}
