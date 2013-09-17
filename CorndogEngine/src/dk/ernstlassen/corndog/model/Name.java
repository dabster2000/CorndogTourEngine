package dk.ernstlassen.corndog.model;

public class Name {

	public String name;
	public int priority;
	
	public Name(String name, int priority) {
		super();
		this.name = name;
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Name [name=" + name + ", priority=" + priority + "]";
	}
}
