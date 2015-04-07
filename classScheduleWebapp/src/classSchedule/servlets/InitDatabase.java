package classSchedule.servlets;

import java.util.Scanner;

import classSchedule.persist.DatabaseProvider;
import classSchedule.persist.FakeDatabase;
import classSchedule.persist.SqliteDatabase;


public class InitDatabase {
	public static void init(Scanner keyboard) {
		System.out.print("Which database (0=fake, 1=sqlite): ");
		int which = Integer.parseInt(keyboard.nextLine());
		if (which == 0) {
			DatabaseProvider.setInstance(new FakeDatabase());
		} else if (which == 1) {
			DatabaseProvider.setInstance(new SqliteDatabase());
		} else {
			throw new IllegalArgumentException("Invalid choice: " + which);
		}
	}
}