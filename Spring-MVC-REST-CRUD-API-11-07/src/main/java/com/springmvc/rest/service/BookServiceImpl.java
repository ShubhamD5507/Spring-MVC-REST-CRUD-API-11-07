package com.springmvc.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.rest.dao.BookDao;
import com.springmvc.rest.entity.Book;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDao bookDao;
	
	@Override
	public boolean addBook(Book book) {

		
		return bookDao.addBook(book);
	}
	
	@Override
	public List<Book> getBook() {

		
		return bookDao.getBook();
	}

	@Override
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

}
