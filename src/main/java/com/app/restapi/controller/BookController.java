package com.app.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/Book")
public class BookController
{
	
	@GetMapping("/find")
	public @ResponseBody ResponseEntity<String> getOneBook()
	{	
		ResponseEntity<String> book = new ResponseEntity<String>("Book Controller", HttpStatus.OK);
		return book;
	}
	
}
