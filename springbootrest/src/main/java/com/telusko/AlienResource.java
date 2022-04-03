package com.telusko;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AlienResource {
	
	@Autowired
	AlienRepositoryORM repoORM;
	
	
	//while calling this web service use this url:- http://localhost:8081/getAliens
	@GetMapping("getAliens")
	public List<Alien> getAliens()
	{
		System.out.println("getAliens");
		List<Alien> la=(List<Alien>) repoORM.findAll();
		return la;
	}
	
	
	@GetMapping("getAlien/{id}")
	public Optional<Alien> getAlien(@PathVariable int id)
	{
		System.out.println("getAlien");
		return  repoORM.findById(id);
	}
	
	

	@PostMapping("createAlien")
	public Alien createAlien(@RequestBody Alien a)
	{
		System.out.println("createAliens");
		System.out.println(a);
		//a.setId(2);
		//a.setName("fgfdgdfhdf");
		return repoORM.save(a);
	}

	

	@PutMapping("updateAlien")
	public Alien updaetAlien(@RequestBody Alien a)
	{
		System.out.println("updateAliens");
		if(repoORM.existsById(a.getId()))
		{
			Alien a1=repoORM.findById(a.getId()).get();
			
			a1.setName(a.getName());
			
			repoORM.save(a1);
		}
	
		return a;
	}
	
	
	
	@DeleteMapping("deleteAlien/{id}")
	public void deleteAlien(@PathVariable int id)
	{
		System.out.println("delete alian "+id);
		Alien a1=repoORM.findById(id).get();
		System.out.println(a1);
		repoORM.deleteById(id);
	}
	
}
