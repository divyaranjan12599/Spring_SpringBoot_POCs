package com.web.demo.repository;

import java.util.ArrayList; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.demo.model.Alien;


@Repository
public  interface AlienRepository extends JpaRepository<Alien, Integer>{
	
	ArrayList<Alien> findByAname(String aname);
	
	ArrayList<Alien> findByAidGreaterThan(int aid);
	
	@Query("from Alien where aid=?1 order by aname")
	ArrayList<Alien> findByAnameSorted(int aid);
}
