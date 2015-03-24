package classSchedule.persist;

import classSchedule.persist.Database;

public class DatabaseProvider {
	private static Database theInstance;
	
	public static void setInstance(Database db) {
		theInstance = db;
	}
	
	public static Database getInstance() {
		if (theInstance == null) {
			throw new IllegalStateException("IDatabase instance has not been set!");
		}
		return theInstance;
	}
}