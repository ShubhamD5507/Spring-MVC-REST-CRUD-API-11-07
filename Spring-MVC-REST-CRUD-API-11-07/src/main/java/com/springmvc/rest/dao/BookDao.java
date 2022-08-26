package com.springmvc.rest.dao;

import java.util.List;

import com.springmvc.rest.entity.Book;

public interface BookDao {
	
	public boolean addBook(Book book);
	
	public List<Book> getBook();
	
	public Book getBookById(int id);


}
