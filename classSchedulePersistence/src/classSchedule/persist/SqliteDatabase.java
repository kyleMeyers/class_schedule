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
	

	@Override
	public Course findCoursebyTitleOrCrn(String courseName, String crn) {
		
		return executeTransaction(new Transaction<Course>() {
			@Override
			public Course execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select courses.* " +			//the entire major tuple
							"  from courses " +
							" where courses.name = ? or courses.crn = ?"
					);
					stmt.setString(1, courseName);
					stmt.setString(2,crn);
					
					Course result = null;
					
					resultSet = stmt.executeQuery();
					if (resultSet.next()) { // query will produce at most 1 course or null if it does not exist
						result = new Course();
						loadCourse(result, resultSet, 1);
					}
					
					return result;			//returns an actual course or null if there is not one
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	

	@Override
	public User newUser(String username, String password) {
		return executeTransaction(new Transaction<User>() {
			@Override
			public User execute(Connection conn) throws SQLException {
				User user = new User();
				
				user.setUsername(username);
				user.setPassword(password);
				
				PreparedStatement stmt = null;
				ResultSet genKeys = null;
				
				try {
					stmt = conn.prepareStatement(
							"insert into users (username, password) values (?, ?)",
							PreparedStatement.RETURN_GENERATED_KEYS
					);
					stmt.setString(1, user.getUsername());
					stmt.setString(2, user.getPassword());
					
					stmt.executeUpdate();
					
					genKeys = stmt.getGeneratedKeys();
					genKeys.next();
					user.setId(genKeys.getInt(1));
					
					System.out.println("Successfully inserted user with id=" + user.getId());
					
					return user;
				} finally {
					DBUtil.closeQuietly(genKeys);
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

	private void loadProfessor(Professor result, ResultSet resultSet, int i) throws SQLException{
		result.setFirstName(resultSet.getString(i++));
		result.setLastName(resultSet.getString(i++));
	}
	
	private void loadCourse(Course result, ResultSet resultSet, int i) throws SQLException{
		result.setId(resultSet.getInt(i++));
		result.setCRN(resultSet.getString(i++));
		result.setName(resultSet.getString(i++));	
	}
	
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
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
					
					stmt3 = conn.prepareStatement(
							"create table courses (" +
							"	id integer primary key," +
							"	crn varchar(10)," +
							"	courseName varchar(40)" +
							")");
					stmt3.executeUpdate();
					
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
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
				List<Course> courseList;
				
				try {
					//this gets the csvs for the initial data to the SQL
					userList = InitialData.getUsers();
					majorList = InitialData.getMajors();
					courseList = InitialData.getCourses();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertUser = null;
				PreparedStatement insertMajor = null;
				PreparedStatement insertCourse = null;
				
				try {
					insertUser = conn.prepareStatement("insert into users values (?, ?, ?)");
					for (User use : userList) {
						insertUser.setInt(1, use.getId());
						insertUser.setString(2, use.getUsername());
						insertUser.setString(3, use.getPassword());
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					
					insertMajor = conn.prepareStatement("insert into majors values (?, ?)");
					for(Major maj : majorList)
					{
						insertMajor.setInt(1, maj.getId());
						insertMajor.setString(2, maj.getName());
						insertMajor.addBatch();
					}
					insertMajor.executeBatch();
					
					insertCourse = conn.prepareStatement("insert into courses values (?, ?, ?)");
					for(Course cour: courseList)
					{
						insertCourse.setInt(1, cour.getId());
						insertCourse.setString(2, cour.getCRN());
						insertCourse.setString(3, cour.getName());
						insertCourse.addBatch();
					}
					insertCourse.executeBatch();
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertUser);
					DBUtil.closeQuietly(insertMajor);
					DBUtil.closeQuietly(insertCourse);
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
		return executeTransaction(new Transaction<Professor>() {
			@Override
			public Professor execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select professors.* " +			//the entire user tuple
							"  from professors " +
							" where professors.firstname = ? and professors.lastname = ?"
					);
					stmt.setString(1, firstname);
					stmt.setString(2, lastname);
					
					Professor result = null;
					
					resultSet = stmt.executeQuery();
					if (resultSet.next()) { 
						result = new Professor();
						loadProfessor(result, resultSet, 1);
					}
					
					return result;			//returns an actual professor or null if there is not one
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}





}
