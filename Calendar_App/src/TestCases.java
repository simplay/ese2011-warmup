import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;


public class TestCases {
	
	public void testUser_SetName(){
		String name = "hans";
		User u1 = new User(name);
		assert u1.name.equals(name);
	}
	
	public void testCalendar_hasEntries(){
		String name = "markus";
		User u1 = new User(name);
		User owner = u1.calendar.getOwner();
		String calName = u1.calendar.name;
		
		assert u1.calendar != null;
		assert calName.equals(name);
		assert u1 == owner;
	}
	
	
	public void testCalendar_hasEvents(){
		String cName = "aname";
		String uName1 = "hans";
		User u1 = new User(uName1);
		Calendar cal = new Calendar(cName, u1);
		Date d1 = new Date(1, 1, 1);
		Event e = new Event(d1, d1, cName, true);
		cal.addEvent(e);
		LinkedList<Event> list = cal.getDayEvents(d1, u1);
		
		assert list.size() == 1;
	}
	
	public void testCalendar_iterator(){
		String cName = "aname";
		String uName1 = "hans";
		String uName2 = "friz";
		
		User u1 = new User(uName1);
		User u2 = new User(uName2);
		
		Date d1 = new Date(1, 1, 1);
		Date d2 = new Date(1, 1, 2);
		Date d3 = new Date(1, 1, 3);
		
		Event e1 = new Event(d1, d1, cName, true);
		Event e2 = new Event(d1, d3, cName, true);
		Event e3 = new Event(d2, d3, cName, true);
		Event e4 = new Event(d3, d3, cName, true);
		Event e5 = new Event(d1, d2, cName, false);
		
		Calendar cal = new Calendar(cName, u1);
		
		cal.addEvent(e1);
		cal.addEvent(e2);
		cal.addEvent(e3);
		cal.addEvent(e4);
		cal.addEvent(e5);
		
		Iterator<Event> iter = cal.getEventLis2(d1, u2);
		
		assert iter.hasNext();
		assert iter.next() != null;
	}
	
	public void testCalendar_iterator2(){
		
	}
	
	public void testCalendar_iterator3(){
		
	}
	
	public void testCalendar_list(){
		String cName = "aname";
		String uName1 = "hans";
		String uName2 = "friz";
		
		User u1 = new User(uName1);
		User u2 = new User(uName2);
		
		Date d1 = new Date(1, 1, 1);
		Event e1 = new Event(d1, d1, cName, false);
		
		Calendar cal = new Calendar(cName, u1);
		
		cal.addEvent(e1);
		
		LinkedList<Event> list = cal.getDayEvents(d1, u2);
		
		// since u1 set e1.is_visible to false u2 should get back an empty List of events after request for events.
		assert list.size() == 0;
	}
	
	public void testCalendar_list2(){
		String cName = "aname";
		String uName1 = "hans";
		String uName2 = "friz";
		
		User u1 = new User(uName1);
		User u2 = new User(uName2);
		
		Date d1 = new Date(1, 1, 1);
		Event e1 = new Event(d1, d1, cName, true);
		
		Calendar cal = new Calendar(cName, u1);
		
		cal.addEvent(e1);
		
		LinkedList<Event> list = cal.getDayEvents(d1, u2);
		
		// since u1 set e1.is_visible to true u2 should get back an list with one event.
		assert list.size() == 1;
	}
	
	public void testCalendar_list3(){
		String cName = "aname";
		String uName1 = "hans";
		String uName2 = "friz";
		
		User u1 = new User(uName1);
		User u2 = new User(uName2);
		
		Date d1 = new Date(1, 1, 1);
		Date d2 = new Date(1, 1, 2);
		Date d3 = new Date(1, 1, 3);
		
		Event e1 = new Event(d1, d1, cName, true);
		Event e2 = new Event(d1, d3, cName, true);
		Event e3 = new Event(d2, d3, cName, true);
		Event e4 = new Event(d3, d3, cName, true);
		Event e5 = new Event(d1, d2, cName, false);
		
		Calendar cal = new Calendar(cName, u1);
		
		cal.addEvent(e1);
		cal.addEvent(e2);
		cal.addEvent(e3);
		cal.addEvent(e4);
		cal.addEvent(e5);
		
		LinkedList<Event> list = cal.getDayEvents(d1, u2);
		
		// since e1, e1 are visibile and start on d1, u2 should get back a list including two entries of u1.
		assert list.size() == 2;
	}
	
	public void testEvent_hasEntries(){
		Date d1 = new Date(1, 1, 1);
		Date d2 = new Date(1, 1, 2);
		String name = "aname";
		boolean flag = true;
		Event e = new Event(d1, d2, name, flag);
		
		assert e.is_visible == flag;
		assert e.start.equals(d1);
		assert e.end.equals(d2);
		assert e.name.equals(name);
	}
	
	public void testEvent_visibility(){
		Date d1 = new Date(1, 1, 1);
		Date d2 = new Date(1, 1, 2);
		String name = "aname";
		boolean flag = false;
		Event e = new Event(d1, d2, name, flag);
		
		assert e.is_visible == flag;
	}
	
}
