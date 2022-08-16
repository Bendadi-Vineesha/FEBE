package com.cts.usecaseproject.model;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subscribedBooks")
public class SubscribedBooks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subbook_id")
	private int id;
	private String name;
	private String title;
	private String category;
	private String author;
	private String publisher;
	private Locale publishedDate;
	private boolean isActive;
	private String Content;
	public String email;
	private int price;
	
	public SubscribedBooks() {
		super();
	}

	public SubscribedBooks(int id, String title, String category, String author, String publisher, Locale publishedDate,
			boolean isActive, String content, String email, int price) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.isActive = isActive;
		Content = content;
		this.email = email;
		this.price = price;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Locale getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Locale publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SubscribedBooks [id=" + id + ", title=" + title + ", category=" + category + ", author=" + author
				+ ", publisher=" + publisher + ", publishedDate=" + publishedDate + ", isActive=" + isActive
				+ ", Content=" + Content + ", emailAddress=" + email + ", price=" + price + "]";
	}
	
	

}
