package com.springmvc.rest.service;

import java.util.List;

import com.springmvc.rest.entity.Book;

public interface BookService {

	public boolean addBook(Book book);
	
	public List<Book> getBook();
	
	public Book getBookById(int id);
}
