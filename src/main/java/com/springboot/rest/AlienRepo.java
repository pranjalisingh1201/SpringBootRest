package com.springboot.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.rest.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

		List<Alien> findByAname(String aname);//Query DSL (Domain Specific Language)
		/*
		 * It should start by find by or get by
		 * Then it should have variable name and first letter should be capital.
		 * 
		 * findbyAnameOrderByAid
		 * findbyAnameOrderByAidDesc
		 * */
	@Query("from Alien where aname= :name")
	List<Alien> find(@Param("name")String aname);
	Alien findByAid(int aid);

}
