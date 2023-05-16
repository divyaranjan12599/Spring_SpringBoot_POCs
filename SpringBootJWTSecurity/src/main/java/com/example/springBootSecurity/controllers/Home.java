package com.example.springBootSecurity.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@RequestMapping("/welcome")
	public String welcome() {
		String text = "This is private page\n";
		text += "This page is not allowed to unauthorized users!!!";
		return text;
	}

}
