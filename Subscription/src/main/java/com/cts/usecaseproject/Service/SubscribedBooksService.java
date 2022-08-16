package com.cts.usecaseproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.usecaseproject.Repository.SubscribedbooksRepository;
import com.cts.usecaseproject.model.SubscribedBooks;

@Service
public class SubscribedBooksService {

	@Autowired
	SubscribedbooksRepository subrepo;

	public SubscribedBooks saveOrUpdateSub(SubscribedBooks books) {
		return subrepo.save(books);
	}

	public SubscribedBooks getBookByEmail(String email) {
		return subrepo.findByEmail(email);
	}

	public SubscribedBooks getBookById(int id) {
		return subrepo.findById(id);

	}
}
