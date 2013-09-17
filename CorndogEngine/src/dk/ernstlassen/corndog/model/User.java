package dk.ernstlassen.corndog.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	public String username;
	public String password;
	public String teamname;
	public ArrayList<Biker> bikers = new ArrayList<>();

	public User(String username, String password, String teamname) {
		super();
		this.username = username;
		this.password = password;
		this.teamname = teamname;
	}
}
