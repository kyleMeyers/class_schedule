package classSchedule.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



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

	
	
}