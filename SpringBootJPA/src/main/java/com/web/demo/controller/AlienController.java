package com.web.demo.controller;

import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.web.demo.model.Alien;
import com.web.demo.repository.AlienRepository;

//@RestController
@Controller
public class AlienController {
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//	}
	
	@Autowired
	private AlienRepository alienRepository;
	
//	@RequestMapping("/")
//	public String home() {
//		return "form";
//	}
	
	@ResponseBody
	@GetMapping(path="/get",produces={"application/json"})
	public List<Alien> getList() {
		System.out.println(alienRepository.findByAname("something"));
		System.out.println(alienRepository.findByAidGreaterThan(100));
		System.out.println(alienRepository.findByAnameSorted(102));
		return alienRepository.findAll();
	}
	
	@RequestMapping("/addAlien")
	public String addAlien1(Alien alien) {
		alienRepository.save(alien);
		return "form";
	}
//	
//	@RequestMapping("/searchAlien")
//	public String searchAlienForm() {
//		return "getById";
//	}
//	
//	@RequestMapping("/getAlien1")
//	public ModelAndView getAlien1(@RequestParam int aid) {
//		ModelAndView mv = new ModelAndView("showAlien");
//		if(alienRepository.findById(aid).orElse(null)!=null)
//			System.out.println(alienRepository.findById(aid));
//		Alien alien = alienRepository.findById(aid).orElse(new Alien());
//		mv.addObject("alien",alien);
//		//m.addAttribute(alien);
//		return mv;
//	}
//	
//	//@ResponseBody
//	@RequestMapping("/deleteAlien/{aid}")
//	public List<Alien> deleteAlien(@PathVariable int aid) {
//		alienRepository.deleteById(aid);
//		return alienRepository.findAll();
//	}
//	
	//@ResponseBody
	@GetMapping("/alien/{aid}")
	public Alien getAlien(@PathVariable int aid) {
		return alienRepository.findById(aid).orElse(new Alien());
	}
	
	@DeleteMapping("/alien/{aid}")
	public Alien deleteAlien(@PathVariable int aid) {
		Alien alien = alienRepository.findById(aid).orElse(new Alien());
		alienRepository.delete(alien);
		return alien;
	}
	
	//@ResponseBody
	@PostMapping("/alien")
	public Alien addAlien(Alien alien) {
		alienRepository.save(alien);
		return alien; 
	}
	
	@PutMapping(path = "/alien/{aid}",consumes = {"application/json"})
	public Alien saveOrUpdateAlien(Alien alien) {
		alienRepository.save(alien);
		return alien; 
	}
}
