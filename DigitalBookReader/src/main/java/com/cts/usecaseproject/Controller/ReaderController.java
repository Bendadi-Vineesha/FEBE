package com.cts.usecaseproject.Controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.usecaseproject.Client.BookReaderClient;
import com.cts.usecaseproject.Exceptions.BookException;
import com.cts.usecaseproject.Model.Book;
import com.cts.usecaseproject.Model.Books;
import com.cts.usecaseproject.Model.SubscribedBooks;
import com.cts.usecaseproject.Model.Subscription;
import com.cts.usecaseproject.Repository.SubscriptionRepository;
import com.cts.usecaseproject.Service.ReaderService;

@RestController
@RequestMapping("/reader")
@CrossOrigin
public class ReaderController {

	@Autowired
	ReaderService service;

	@Autowired
	BookReaderClient client;
	
	@Autowired
	SubscriptionRepository subrepo;

	@PostMapping(value = "/save/subscribebooks", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public SubscribedBooks subscribeToABook(@RequestBody SubscribedBooks subbook) {
		Book auth = client.getBookByTitleName(subbook.getTitle());
		if (auth.getTitle() == subbook.getTitle())
			subbook.setContent(auth.getContent());
		subbook.setEmail(auth.getEmailAddress());
		subbook.setAuthor(auth.getAuthor());
		subbook.setCategory(auth.getCategory());
		subbook.setPublisher(auth.getPublisher());
		subbook.setPublishedDate(auth.getPublishedDate());
		subbook.setPrice(auth.getPrice());
		subbook.setTitle(auth.getTitle());
		return service.saveOrUpdateSub(subbook);

	}

	@GetMapping("/subscribedbooks")
	public SubscribedBooks getSubscribedBooksByEmail(@RequestParam(name = "email") String email) {
		return service.getBookByEmail(email);
	}

	@GetMapping("/subscribedbooks/byid")
	public SubscribedBooks getSubscribedBooksById(@RequestParam(name = "id") int id) {
		return service.getBookById(id);
	}

	@GetMapping("/by-publisher")
	public List<Book> getBookByPublisher(@RequestParam(name = "publisher") String publisher) {
		return client.getBookByPublisher(publisher);

	}

	@GetMapping("/by-author")
	public List<Book> getBookByAuthor(@RequestParam(name = "author") String author) {
		return client.getBookByAuthorName(author);

	}
	
	@GetMapping("/by-category")
	public List<Book> getBookByCategory(@RequestParam(name = "category") String category) {
		return client.getBookByCategory(category);

	}

	@GetMapping("/by-price")
	public List<Book> getBookByPrice(@RequestParam(name = "price") int price) {
		return client.getBookByPrice(price);

	}

	@GetMapping("/by-title")
	public String getBookByTitle(@RequestParam(name = "title") String title) {
		String book = client.getBookByTitle(title);
		return book;

	}
	@GetMapping("/getAllBooks")
	public List<Books> getAllBooks(){
	List<Books> books =	client.getAllBooks();
	return books;
		
	}
	
	@GetMapping("/titlename")
	public Book getBookByTitleName(@RequestParam(name = "title") String title) throws BookException {
		Book ra = client.getBookByTitleName(title);
		return ra;
	}

	@GetMapping("/subscribe/{subscriberName}/{subscriberEmail}/{book_id}")
	public Subscription subscribe(@PathVariable(value="subscriberName") String subscriberName,@PathVariable(value="subscriberEmail") String subscriberEmail,
			@PathVariable(value="book_id") int book_id) {
				Subscription sub = new Subscription();
				sub.setSubscriberName(subscriberName);
				sub.setSubscriberEmail(subscriberEmail);
				sub.setTime(LocalDateTime.now());
				Book book= client.SubscribeBook(book_id);
				if(book!=null) {
					sub.setBook_id(book_id);
					subrepo.save(sub);
					return sub;
				}
				return null;
	}
	
	@GetMapping("/subscribedBook/{subscriberEmail}")
	public List<Book> getSubscribedBooks(@PathVariable(value="subscriberEmail") String subscriberEmail){
		List<Book> bookList = new ArrayList<>();
		List<Subscription> list=subrepo.findBySubscriberEmail(subscriberEmail);
		for(Subscription sub:list) {
			Book book = client.SubscribedBook(sub.getBook_id());
			bookList.add(book);
		}
		if(bookList!=null) {
			return bookList;
		}else
		return null;
		}
	@DeleteMapping("/deleteBookBySubIdAndEmail/{bookId}/{readerEmail}")
	public Subscription deleteBookBySubscriptionIdAndEmail(@PathVariable int bookId,@PathVariable String readerEmail) {
		Subscription sub = subrepo.findBysubIdandReaderEmail(bookId,readerEmail);
		System.out.println(sub);
		if(sub!=null) {
			long hours=ChronoUnit.HOURS.between(sub.getTime(), LocalDateTime.now());
			System.out.println(hours);
			if(hours<24) {
				subrepo.deleteById(sub.getSub_id());
				return sub;
			}
		}
		return null;
	}
	}
