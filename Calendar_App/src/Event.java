import java.util.Date;


public class Event {
	public Date start;
	public Date end;
	public String name;
	public boolean is_visible;
	
	public Event(Date start, Date end, String name, boolean is_visible){
		this.start = start;
		this.end = end;
		this.name = name;
		this.is_visible = is_visible;
	}
	
}
