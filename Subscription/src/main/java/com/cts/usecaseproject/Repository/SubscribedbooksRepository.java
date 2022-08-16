package com.cts.usecaseproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.usecaseproject.model.SubscribedBooks;
@Repository
public interface SubscribedbooksRepository extends JpaRepository<SubscribedBooks, Integer> {

	SubscribedBooks findByEmail(String email);
	
	SubscribedBooks findById(int id);

	
	
}
