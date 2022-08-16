package com.cts.usecaseproject.Model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subscription")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_id")
	private int Sub_id;
	private String subscriberName;
	private String subscriberEmail;
	private LocalDateTime time;
	private int book_id;
	
	public Subscription() {
		super();
	}

	public Subscription(int sub_id, String subscriberName, String subscriberEmail, LocalDateTime time, int book_id) {
		this(subscriberName,subscriberEmail,book_id);
		Sub_id = sub_id;
		this.time = time;
	
	}

	public Subscription(String subscriberName, String subscriberEmail, int book_id) {
		super();
		this.subscriberName = subscriberName;
		this.subscriberEmail = subscriberEmail;
		this.book_id = book_id;
	}



	public int getSub_id() {
		return Sub_id;
	}

	public void setSub_id(int sub_id) {
		Sub_id = sub_id;
	}

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public String getSubscriberEmail() {
		return subscriberEmail;
	}

	public void setSubscriberEmail(String subscriberEmail) {
		this.subscriberEmail = subscriberEmail;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	
	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Subscription [Sub_id=" + Sub_id + ", subscriberName=" + subscriberName + ", SubscriberEmail="
				+ subscriberEmail + ", time=" + time + ", book_id=" + book_id + "]";
	}

}
