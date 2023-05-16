package com.example.springBootSecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootSecurity.helper.JwtUtil;
import com.example.springBootSecurity.model.JwtRequest;
import com.example.springBootSecurity.model.JwtResponse;
import com.example.springBootSecurity.services.CustomUserDetailsService;

@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value = "/generateToken",method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.out.println(jwtRequest);
		
		try {
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials!!!");
		}
		
		UserDetails userDetails =  this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT : "+token);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
}
