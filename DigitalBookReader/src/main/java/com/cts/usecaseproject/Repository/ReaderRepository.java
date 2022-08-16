package com.cts.usecaseproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.usecaseproject.Model.Reader;
import com.cts.usecaseproject.Model.SubscribedBooks;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {

	

}
