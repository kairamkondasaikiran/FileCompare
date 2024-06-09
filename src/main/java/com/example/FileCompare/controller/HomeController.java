package com.example.FileCompare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FileCompare.service.CompareService;

@RestController
public class HomeController {

	@Autowired
	private CompareService compareService;
	
	@GetMapping("/home")
	public ResponseEntity<String> welcome(){
		compareService.compare();
		
		String a="kwxkw";
		
		
		System.out.println(a);
		
		
		String b="kwxkw";
		
		System.out.println(b);
		
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
}
