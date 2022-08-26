package com.springmvc.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	private int bookID;
	
	private String bookName;
	
	private String authorName;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(int bookID, String bookName, String authorName) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.authorName = authorName;
	}
	
	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bookName=" + bookName + ", authorName=" + authorName + "]";
	}

}
