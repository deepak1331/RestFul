package com.edu.Rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.edu.Rest.dao.AlienRepository;
import com.edu.Rest.model.Alien;

@Path("aliens")
public class AlienResource {
	// returns a String
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAlien() {
		System.out.println("Get Alien method called.");
		Alien a1 = new Alien(101, "Deepak", "Java", "Softcrylic", 29);
		return a1.toString();
	}

	// Returns as XML

	@GET
	@Path("alien/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Alien getAlien(@PathParam("id") int id) {
		System.out.println("Get Alien method called.");
		return new AlienRepository().getAlienById(id);
	}

//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public List<Alien> getAliens() {
//		AlienRepository repo = new AlienRepository();
//		System.out.println("Get Aliens method called.");
//		List<Alien> list = repo.getList();
//		return list;
//	}

}
