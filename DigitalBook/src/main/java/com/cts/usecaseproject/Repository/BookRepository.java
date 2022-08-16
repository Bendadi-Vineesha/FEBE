package com.cts.usecaseproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.usecaseproject.Model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("select b from Book b where b.id = ?1 and b.isBlocked='no'")
	Book findById(int id);
	
	@Query("select b from Book b where b.id = ?1")
	Book findByBookId(int id);
	
	@Query("select b from Book b where b.author = ?1 and b.isBlocked='no'")
	List<Book> findByAuthor(String author);

	@Query("select b from Book b where b.price = ?1 and b.isBlocked='no'")
	List<Book> findByPrice(int price);

	@Query("select b from Book b where b.category = ?1 and b.isBlocked='no'")
	List<Book> findByCategory(String Category);

	@Query("select b from Book b where b.publisher = ?1 and b.isBlocked='no'")
	List<Book> findByPublisher(String publisher);
	
	@Query("select b from Book b where b.title = ?1 and b.isBlocked='no'")
	Book findByTitle(String title);
	
	@Query("select b from Book b where b.author = ?1 ")
	List<Book> findByAuthorName(String author);

}