package dk.ernstlassen.corndog.json;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import dk.ernstlassen.corndog.dao.BikerDao;
import dk.ernstlassen.corndog.model.Biker;

@Path("user")
public class Bikers {

	@GET
	@Path("/{username}/bikers")
	@Produces("application/xml")
	public ArrayList<Biker> getAllBikers(@PathParam("username") String username) {
		System.out.println("HER!");
		BikerDao bikerDao = BikerDao.getInstance();
		
		return bikerDao.getBikers(username);
	}
	
}
