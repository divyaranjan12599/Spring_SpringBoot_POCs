package com.web.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	//@ResponseBody
//	public String home(HttpServletRequest req) {
//		HttpSession session = req.getSession();
	public ModelAndView home(Alien alien
			//@RequestParam("name")String myName
//			,HttpSession session
			) {
		//String name = req.getParameter("name");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("obj", alien);
//		System.out.println("home called..."+myName);
//		mv.addObject("name", myName);
		//mv.setViewName("home");
		//req.setAttribute("name", name);
//		session.setAttribute("name", myName);
//		return "home";
		return mv; 
	}
}
