package dk.ernstlassen.corndog.dao;

import java.util.ArrayList;
import java.util.HashMap;

import dk.ernstlassen.corndog.model.Biker;
import dk.ernstlassen.corndog.model.Names;
import dk.ernstlassen.corndog.model.User;

public class BikerDao {

	private static BikerDao instance;
	
	public HashMap<String, User> users = new HashMap<>();
	
	private BikerDao() {
		User elver = new User("elver", "1234", "Team Report");
		elver.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		elver.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		elver.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		elver.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		elver.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		elver.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		elver.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		elver.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		elver.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		elver.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		
		User hans = new User("hans", "1234", "Team Skin");
		hans.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		hans.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		hans.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		hans.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		hans.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		hans.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		hans.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		hans.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		hans.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		hans.bikers.add(new Biker(Names.randomFirstname()+" "+Names.randomLastname(), Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 40+60, Math.random() * 40+160, 10));
		
	}
	
	public static BikerDao getInstance() {
		if(instance == null) instance = new BikerDao();
		return instance;
	}
	
	public ArrayList<Biker> getBikers(String username) {
		return users.get(username).bikers;
	}
	
	public User getUser(String username) {
		return users.get(username);
	}
}
