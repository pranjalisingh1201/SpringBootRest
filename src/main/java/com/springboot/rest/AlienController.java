package com.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.model.Alien;
@RestController
public class AlienController {
	
	@Autowired
	AlienRepo alienRepo;
	
	@GetMapping("aliens")
	public List<Alien> getAliens()
	{
		List<Alien> alien = alienRepo.findAll();//We dont need model as it has session ,Also we can just return the data with @Response Body.
		return alien;
	}
	@GetMapping(path="aliens",produces= {"application/xml"})
	public List<Alien> getAllAliens()
	{
		List<Alien> alien = alienRepo.findAll();//We dont need model as it has session ,Also we can just return the data with @Response Body.
		return alien;
	}
	
	@GetMapping("alien/{aid}")
	public Alien getAlien(@PathVariable("aid")int aid)
	{
		Alien alien = alienRepo.findByAid(aid);//We dont need model as it has session ,Also we can just return the data with @Response Body.
		return alien;
	}

	@PostMapping("alien")
	public Alien addAlien(Alien alien)
	{
		alienRepo.save(alien);//We dont need model as it has session ,Also we can just return the data with @Response Body.
		return alien;
	}
	
	@PostMapping(path="alienadd",consumes= {"application/json"})
	public Alien addAlienData(@RequestBody Alien alien)
	{
		alienRepo.save(alien);//We use @RequestBody to convert json to java object.
		return alien;
	}
}
