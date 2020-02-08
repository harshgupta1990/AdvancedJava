package com.telusko.demorest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	
	//AlienRepository repo=new AlienRepository();
	AlienRepositoryDB repoDB=new AlienRepositoryDB();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("getAliens")
	public List<Alien> getAliens()
	{
		//List<Alien> la=repo.getAliens();
		List<Alien> la=repoDB.getAliens();
		return la;
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("getAlien/{id}")
	public Alien getAlien(@PathParam("id") int id)
	{
		return repoDB.getAlien(id);
	}
	
	
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("createAlien")
	public Alien createAlien(Alien a)
	{
		 return repoDB.createAlien(a);
	}

	
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("updateAlien")
	public Alien updaetAlien(Alien a)
	{
		if(repoDB.getAlien(a.getId()).getId()==0)
		{
			return repoDB.createAlien(a);
		}
		else
		{
			return repoDB.updateAlien(a);
		}
	}
	
	
	@DELETE
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("deleteAlien/{id}")
	public Alien deleteAlien(@PathParam("id") int id)
	{
		Alien a=repoDB.getAlien(id); 
		
		if(a.getId()!=0)
		{
			repoDB.deleteAlien(id);
		}
		
		return a;
	}
	
}
