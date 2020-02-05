package com.telusko.demorest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Alien getAlien()
	{
		System.out.println("get alien called");
		Alien a1=new Alien();
		a1.setName("Harshit");
		a1.setPoints(23);
		return a1;
	}

}
