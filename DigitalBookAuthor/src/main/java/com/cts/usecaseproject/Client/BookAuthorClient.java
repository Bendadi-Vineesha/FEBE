package com.cts.usecaseproject.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.usecaseproject.Model.Book;

@FeignClient("DIGITAL-AUTHOR")
public interface BookAuthorClient {

	@PostMapping("/api/v1/digitalbooks/books/create")
	public Book createBook(@RequestBody Book book);
	
	@GetMapping("/api/v1/digitalbooks/books/create/msg")
	public String gerMessage();
	
	@PutMapping("/api/v1/digitalbooks/books/updateBook/{id}")
	public Book updateBook(@PathVariable(value = "id") int bookId,@RequestBody Book book);
	
}
