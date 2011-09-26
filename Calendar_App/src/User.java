
public class User {
	public String name;
	public Calendar calendar;
	public User(String name){
		assert name != null : "Parameter not allowed to be null";
		assert name.isEmpty()==false: "Empty name, User must have a name";
		this.name = name;
		calendar = new Calendar(name, this);
	}
}
