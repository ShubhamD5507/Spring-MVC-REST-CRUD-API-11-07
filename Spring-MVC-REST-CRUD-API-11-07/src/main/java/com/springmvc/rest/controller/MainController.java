package com.springmvc.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.rest.entity.Book;
import com.springmvc.rest.service.BookService;

@RestController // Combination of @Controller and @ResponseBody
public class MainController {
	
	@Autowired	
	BookService service;
	
	//@ResponseBody we can write it on method but as we are using @RestController So not Required to write it.
	
	@PostMapping("/book") // @PostMapping it's an flavour of @RequestMapping
	public ResponseEntity<?> saveBook(@RequestBody Book book) {
		
		boolean isSaved = service.addBook(book);
		
		if(isSaved) {

			return ResponseEntity.ok("Book records Saved Successfully...");
		}
		else {
			return ResponseEntity.ok("Book records unable to Save...");
		}
	}
	
	@GetMapping("/books")
	public ResponseEntity<?> getBook() {
		
		List<Book> books = service.getBook();
		System.out.println(books);
		if(books!=null) {

			return ResponseEntity.ok(books);
		}
		else {
			return ResponseEntity.ok("Book records unable to Save...");
		}
	}
	
	@GetMapping("/books/{bookID}")
	public ResponseEntity<?> getBookById(@PathVariable int bookID) {
		
		//System.out.println("ID of the book is "+bookID);
		
		Book book = service.getBookById(bookID);
		System.out.println(book);

		if(book!=null) {

			return ResponseEntity.ok(book);
		}
		else {
			return ResponseEntity.ok("Book records unable to Save...");
		}
	}
		
}
