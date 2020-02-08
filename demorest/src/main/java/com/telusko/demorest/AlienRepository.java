package com.telusko.demorest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AlienRepository {
	
	List<Alien> la;
	
	AlienRepository()
	{
		
		la=new ArrayList<Alien>();
		
		Alien a1=new Alien();
		a1.setName("Harshit");
		a1.setId(23);

		
		Alien a2=new Alien();
		a2.setName("Pulkit");
		a2.setId(25);

		
		Alien a3=new Alien();
		a3.setName("Abhinav");
		a3.setId(27);
		
		la=Arrays.asList(a1,a2,a3);
		
//		la.add(a1);
//		la.add(a2);
//		la.add(a3);
	}
	
	
	public List<Alien> getAliens()
	{
		System.out.println("get aliens called");
		return la;
	}
	
	
	public Alien getAlien(int id)
	{
		System.out.println("get alien called");
		
		for(Alien a:la)
		{
			if(id==a.getId())
			{
				return a;
			}
		}
		
		return new Alien();
		
	}
	
	public List<Alien> createAlien(Alien a)
	{
		la.add(a);
		return la;
	}

}
