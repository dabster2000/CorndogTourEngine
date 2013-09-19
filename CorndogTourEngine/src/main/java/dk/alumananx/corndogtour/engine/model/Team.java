package dk.alumananx.corndogtour.engine.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonIgnore;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Team {

	@Id
	public String username;
	public String password;
	public String teamname;
	//@JsonIgnore public ArrayList<Biker> bikers = new ArrayList<>();

	public Team() {
	}
	
	public Team(String username, String password, String teamname) {
		super();
		this.username = username;
		this.password = password;
		this.teamname = teamname;
	}
	
	public static Team fromJsonToUser(String json) {
		return new JSONDeserializer<Team>().deserialize(json, Team.class);
	}
	
	public String toJson() {
		return new JSONSerializer().exclude("*.class").exclude("password").serialize(this);
	}
	
	public String toJsonDeep() {
		return new JSONSerializer().exclude("*.class").exclude("password").serialize(this);
	}

}
