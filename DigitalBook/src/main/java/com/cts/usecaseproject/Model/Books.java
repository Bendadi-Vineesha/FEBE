package com.cts.usecaseproject.Model;

import java.util.Locale;

public class Books {
	private int id;
	private String title;
	private String category;
	private String author;
	private String publisher;
	private Locale publishedDate;
	private String isBlocked;
	private String Content;
	public String emailAddress;
	private int price;

	public Books() {
		super();
	}

	public Books(int id, String title, String category, String author, String publisher, Locale publishedDate,
			String isBlocked, String content, String emailAddress, int price) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.isBlocked = isBlocked;
		Content = content;
		this.emailAddress = emailAddress;
		this.price = price;
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

	public String getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(String isBlocked) {
		this.isBlocked = isBlocked;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", category=" + category + ", author=" + author + ", publisher="
				+ publisher + ", publishedDate=" + publishedDate + ", isBlocked=" + isBlocked + ", Content=" + Content
				+ ", emailAddress=" + emailAddress + ", price=" + price + "]";
	}
	}
