package com.cts.usecaseproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.usecaseproject.Client.SubscribeClient;
import com.cts.usecaseproject.Model.Book;
import com.cts.usecaseproject.Service.SubscribedBooksService;
import com.cts.usecaseproject.model.SubscribedBooks;


@RestController
@RequestMapping("/subscribe")
public class SubscribedBooksController {
	
	@Autowired
	SubscribedBooksService service;
	
	@Autowired
	SubscribeClient client;
	
	@PostMapping("/save/subscribebooks")
	public SubscribedBooks subscribeToABook(@RequestBody SubscribedBooks subbook) {
		Book auth = client.getBookByTitle(subbook.getTitle());
		if (auth.getTitle() == subbook.getTitle())
			subbook.setContent(auth.getContent());
		subbook.setEmail(auth.getEmailAddress());
		subbook.setAuthor(auth.getAuthor());
		subbook.setCategory(auth.getCategory());
		subbook.setPublisher(auth.getPublisher());
		subbook.setPublishedDate(auth.getPublishedDate());
		subbook.setPrice(auth.getPrice());
		subbook.setTitle(auth.getTitle());
		subbook.setActive(auth.isActive());
		return service.saveOrUpdateSub(subbook);

	}

	
	
	@GetMapping("/subscribedbooks")
	public SubscribedBooks getSubscribedBooksByEmail(@RequestParam(name = "email") String email) {
		return service.getBookByEmail(email);
	}
	
	@GetMapping("/subscribedbooks/byid")
	public SubscribedBooks getSubscribedBooksById(@RequestParam(name="id") int id) {
		return service.getBookById(id);
	}
	

}
