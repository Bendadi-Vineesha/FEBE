package com.cts.usecaseproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.usecaseproject.Exceptions.BookException;
import com.cts.usecaseproject.Model.Book;
import com.cts.usecaseproject.Repository.BookRepository;
import com.cts.usecaseproject.Service.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks/books")
@CrossOrigin
public class BookController {

	// catergory,author,price,publisher
	
	@Autowired
	BookRepository repo;


	@Autowired
	BookService service;

	@GetMapping("/msg")
	public String message() {
		return "hello";
	}

	@PostMapping("/create")
	//@KafkaListener(topics = "create_book", groupId = "group_id", containerFactory = "userKafkaListenerFactory")
	public Book CreateBook(@RequestBody Book authordettails) {
		System.out.println("====================================");
		return service.saveOrUpdate(authordettails);

	}

	@PostMapping("/subscribedbooks")
	public Book SubscribeBook(@RequestBody Book authordettails) {
		return service.saveOrUpdate(authordettails);
	}

	@GetMapping(value = "/getbooks")
	public List<Book> getAllBooks() {
		return service.getBooks();

	}

	@DeleteMapping("/{id}")
	public String DeleteBook(@PathVariable int id) {
		service.delete(id);
		return "deleted succesfully";
	}

	@GetMapping("/price")
	public ResponseEntity<List<Book>> getBookByPrice(@RequestParam(name = "price") int price) throws BookException {
		List<Book> rp = service.getBookByPrice(price);
		return ResponseEntity.ok().body(rp);
	}

	@GetMapping("/author")
	public ResponseEntity<List<Book>> getBookByAuthor(@RequestParam(name = "author") String name) throws BookException {
		List<Book> ra = service.getBookByAuthor(name);
		return ResponseEntity.ok().body(ra);
	}

	@GetMapping("/publisher")
	public ResponseEntity<List<Book>> getBookByPublisher(@RequestParam(name = "publisher") String publisher)
			throws BookException {
		List<Book> ra = service.getBookByPublisher(publisher);
		return ResponseEntity.ok().body(ra);
	}

	@GetMapping("/category")
	public ResponseEntity<List<Book>> getBookByCategory(@RequestParam(name = "category") String category)
			throws BookException {
		List<Book> ra = service.getBookByCategory(category);
		return ResponseEntity.ok().body(ra);
	}

//	@GetMapping("/category")
//	public String getBookByCategory(@RequestParam(name = "category") String category)
//			throws BookException {
//		List<Book> ra = service.getBookByCategory(category);
//		for(Book b : ra) {
//			if(b.getIsBlocked().equals("yes")) {
//				return "book is blocked by author";
//			}
//		}
//		return ra.toString();
//	}
//	
	
	@GetMapping("/titlename")
	public ResponseEntity<Book> getBookByTitleName(@RequestParam(name = "title") String title) throws BookException {
		Book ra = service.getBookByTitle(title);
		return ResponseEntity.ok().body(ra);
	}

	@GetMapping("/title")
	public String getBookByTitle(@RequestParam(name = "title") String title) throws BookException {
		Book ra = service.getBookByTitle(title);
		if (ra.getIsBlocked().equals("yes")) {
			return "book is blocked by author";
		}
       return ra.toString();
		
		

	}

	@PutMapping("/updateBook")
		//@PutMapping("/updateBook")
//	@KafkaListener(topics = "create_book", groupId = "group_id", containerFactory = "userKafkaListenerFactory")
	public Book updateBookById(@RequestBody Book book) {
			//public Book updateBookById(@RequestBody Book book) {
		System.out.println(book);
		Book b = repo.findByBookId(book.getId());
		System.out.println(b);
		b.setAuthor(book.getAuthor());
		b.setCategory(book.getCategory());
		b.setContent(book.getContent());
		b.setPrice(book.getPrice());
		b.setPublishedDate(book.getPublishedDate());
		b.setTitle(book.getTitle());
		b.setPublisher(book.getPublisher());
		b.setIsBlocked(book.getIsBlocked());
		//System.out.println(b);
		return service.saveOrUpdate(b);
	}
	

	
	@GetMapping("/getbook")
	public Book getBookById(@RequestParam(name="id") int id) {
	Book b = service.getBookById(id);
	return b;
	}
	
	@GetMapping("/subscribeBook")
	public Book subscribeBook(@RequestParam int id) {
		return service.buyBook(id);
	}

	@GetMapping("/subscribedBook")
	public Book subscribedBook(@RequestParam int id) {
		return service.buyBook(id);
	}
	
	@GetMapping("/nameauthor")
	public ResponseEntity<List<Book>> getBookByAuthorName(@RequestParam(name = "author") String name) throws BookException {
		List<Book> ra = service.getBookByAuthorName(name);
		return ResponseEntity.ok().body(ra);
	}
}