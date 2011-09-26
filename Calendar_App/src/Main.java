import java.util.Date;
import java.util.LinkedList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User u1 = new User("hans");
		User u2 = new User("marc");
		@SuppressWarnings("deprecation")
		Date d1 = new Date(1, 1, 1);
		@SuppressWarnings("deprecation")
		Date d2 = new Date(1, 1, 2);
		@SuppressWarnings("deprecation")
		Date d3 = new Date(1, 1, 3);
		
		u2.calendar.addEvent(d1, d2, "test1", true);
		u2.calendar.addEvent(d1, d2, "test2", false);
		u2.calendar.addEvent(d1, d2, "test3", true);
		u2.calendar.addEvent(d2, d2, "test4", true);
		u2.calendar.addEvent(d1, d2, "test5", true);
		
		
		LinkedList<Event> es = u2.calendar.getDayEvents(d2, u1);
		for(Event e : es) System.out.println(e.name);
		
	}

}
