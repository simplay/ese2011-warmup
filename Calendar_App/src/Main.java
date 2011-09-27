import java.util.Date;
import java.util.LinkedList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestCases tests = new TestCases();
		
		// calendar tests
		tests.testCalendar_hasEntries();
		tests.testCalendar_hasEvents();
		tests.testCalendar_iterator();
		tests.testCalendar_iterator2();
		tests.testCalendar_iterator3();
		tests.testCalendar_list();
		tests.testCalendar_list2();
		tests.testCalendar_list3();
		
		// event tests
		tests.testEvent_hasEntries();
		tests.testEvent_visibility();
		
		// user tests
		tests.testUser_SetName();
	}

}
