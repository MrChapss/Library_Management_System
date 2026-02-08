package lms.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.beans.factory.annotation.Autowired;

import lms.model.Book;

@RestController
@RequestMapping("/LMS/book")
public class BooksController {
/*
	@Autowired
	private Book_Service service;
	
	@PostMapping("/add")
	public String addBook(@RequestBody Book details) {
		service.addBook(details.getBookName(), details.getBookId());
		return "Added book";
	}
*/
}
