package dk.ernstlassen.corndog.model;

import java.util.ArrayList;


public class User {

	public String username;
	public String password;
	public String teamname;
	public ArrayList<Biker> bikers = new ArrayList<>();

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, String teamname) {
		super();
		this.username = username;
		this.password = password;
		this.teamname = teamname;
	}
	
}
