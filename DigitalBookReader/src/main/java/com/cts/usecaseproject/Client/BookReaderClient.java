package com.cts.usecaseproject.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.usecaseproject.Model.Book;
import com.cts.usecaseproject.Model.Books;

@FeignClient("DIGITAL-BOOK")
public interface BookReaderClient {

	@GetMapping("/api/v1/digitalbooks/books/publisher")
	public List<Book> getBookByPublisher(@RequestParam(name = "publisher") String publisher);

	@GetMapping("/api/v1/digitalbooks/books/nameauthor")
	public List<Book> getBookByAuthorName(@RequestParam(name = "author")String author);
	
	@GetMapping("/api/v1/digitalbooks/books/category")
	public List<Book> getBookByCategory(@RequestParam(name = "category")String category);
	
	@GetMapping("/api/v1/digitalbooks/books/price")
	public List<Book> getBookByPrice(@RequestParam(name = "price")int price);
	
	@GetMapping("/api/v1/digitalbooks/books/titlename")
	public Book getBookByTitleName(@RequestParam(name = "title")String title);
	
	@GetMapping("/api/v1/digitalbooks/books/title")
	public String getBookByTitle(@RequestParam(name = "title")String title);
	
	@GetMapping("/api/v1/digitalbooks/books/getbooks")
	public List<Books> getAllBooks();
	
	@GetMapping("/api/v1/digitalbooks/books/subscribeBook")
	public Book SubscribeBook(@RequestParam int id);
	
	@GetMapping("/api/v1/digitalbooks/books/subscribedBook")
    public Book SubscribedBook(@RequestParam int id);
}
