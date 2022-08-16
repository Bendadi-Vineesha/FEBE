package com.cts.usecaseproject.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.usecaseproject.Model.Book;

@FeignClient("SUBSCRIPTION")
public interface SubscribeClient {

	@GetMapping("/api/v1/digitalbooks/books/getbooks")
	public List<Book> getAllBooks();
	
	@PostMapping("/api/v1/digitalbooks/books/subscribedbooks")
	public Book subscribedBooks(@RequestBody Book book);

	@GetMapping("/api/v1/digitalbooks/books/title")
	public Book getBookByTitle(@RequestParam(name = "title")String title);

	
}
