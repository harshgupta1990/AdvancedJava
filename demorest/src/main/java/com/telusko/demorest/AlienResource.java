package com.telusko.demorest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	
	AlienRepository repo=new AlienRepository();;
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("getAliens")
	public List<Alien> getAliens()
	{
		List<Alien> la=repo.getAliens();
		return la;
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("getAlien/{id}")
	public Alien getAlien(@PathParam("id") int id)
	{
		return repo.getAlien(id);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("createAlien")
	public List<Alien> getAlien(Alien a)
	{
		 return repo.createAlien(a);
	}

}
