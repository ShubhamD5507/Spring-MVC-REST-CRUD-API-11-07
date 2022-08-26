package com.springmvc.rest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.rest.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBook(Book book) {
		Session session = null;
		try {
			 session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(book);
			tx.commit();
			System.out.println("Book records saved Successfully...");
			return true;

		} catch (Exception e) {
			
			System.out.println("Book records unable to save in Database...");
			e.printStackTrace();
			return false;
		}
		finally {
			if(session!=null);
		}
	}

	@Override
	public List<Book> getBook() {
		
		try {
			String query = "from Book";
			
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();
			
			Query<Book> q = session.createQuery(query);
			List<Book> books = q.list();
			txn.commit();
			session.close();
			System.out.println("List of Books retrieved Successfully...");
			return books;
			
		} catch (Exception e) {
			
			System.out.println("Unable to get List Books");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Book getBookById(int id) {
		try {
			String query = "from Book Where bookID = :ID";
			
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();
			
			Query<Book> q = session.createQuery(query);
			q.setParameter("ID", id);
			
			Book book = q.uniqueResult();
			txn.commit();
			session.close();
			System.out.println("Book records retrieved Successfully...");
			return book;
			
		} catch (Exception e) {
			
			System.out.println("Unable to retrieve Book records");
			e.printStackTrace();
			return null;
		}
	}
	
}
