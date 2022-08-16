package com.cts.usecaseproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.usecaseproject.Model.Author;
import com.cts.usecaseproject.Model.AuthorModel;
import com.cts.usecaseproject.Repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository repo;

//	@Autowired
//	private PasswordEncoder bcryptEncoder;

	public Author saveAuthorDetails(AuthorModel authordetails) {
		Author newUser = new Author();
		newUser.setUsername(authordetails.getUsername());
	//	newUser.setPassword(bcryptEncoder.encode(authordetails.getPassword()));
		newUser.setPassword(authordetails.getPassword());
			return repo.save(newUser);
	}

}
