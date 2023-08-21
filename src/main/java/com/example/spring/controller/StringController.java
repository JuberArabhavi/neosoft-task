package com.example.spring.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.service.StringService;

@RestController
@RequestMapping("/string")
public class StringController {

	@Autowired
	private StringService stringService;
	
	@PutMapping("/api/v1/acceptAndDisplayWords")
	public HashMap<Character, Integer> acceptAndDisplayWords(@RequestBody String string) {
		return stringService.acceptNoofWords(string);	
	}
	
}
