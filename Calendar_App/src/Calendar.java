import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;


public class Calendar {
	public String name;
	private User owner;
	private LinkedList<Event> events;
	
	public Calendar(String name, User owner){
		this.name = name;
		this.owner = owner;
		events = new LinkedList<Event>();
	}
	
	public void addEvent(Date startDate, Date endDate, String name, boolean is_visible){
		Event ev = new Event(startDate, endDate, name, is_visible);
		events.add(ev);
	}
	
	/**
	 * obtain a list of events a user is allowed to see in a calendar for a given date.
	 **/
	public LinkedList<Event> getDayEvents(Date day, User requester){
		// temporary result linked list
		LinkedList<Event> events_tmp = new LinkedList<Event>();
		
		// test if requester references to same object as owner. if true, we have the same user,
		// therefore, the requester gets full access to its calendar data (since he is the owner of it)
		boolean is_owner = owner == requester; 
		
		// requester is owner
		if(is_owner){
			for(Event e : events)
				if(e.start.equals(day)) events_tmp.add(e);
			
		// requester is not the owner of the calendar ==> do visibility check.	
		}else{
			for(Event e : events)
				if(e.is_visible && e.start.equals(day)) events_tmp.add(e);
		}
		return events_tmp;
	}
	
	
	public Iterator<Event> getEventLis2(Date start, User requester){
		// temporary result linked list
		LinkedList<Event> events_tmp = new LinkedList<Event>();
		
	
		// test if requester references to same object as owner. if true, we have the same user,
		// therefore, the requester gets full access to its calendar data (since he is the owner of it)
		boolean is_owner = owner == requester; 
		
		// requester is owner
		if(is_owner){
			for(Event e : events)
				if((e.start.after(start) || e.start.equals(start))) events_tmp.add(e);
			
		// requester is not the owner of the calendar ==> do visibility check.	
		}else{
			for(Event e : events)
				if(e.is_visible && (e.start.after(start) || e.start.equals(start)) ) events_tmp.add(e);
		}
		// Iterator itr = al.iterator();
		Iterator<Event> iter = events_tmp.iterator();
		return iter;
	}
}
