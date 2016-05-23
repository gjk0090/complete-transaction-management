package com.gjk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gjk.domain.Book;

@Repository
// no need to implement this DAO
// CrudRepository will auto implement boilerplate methods
public interface BookRepository extends CrudRepository<Book, String> {
 
	// this method will be auto created according to Spring convention
    public Iterable<Book> findBooksByAuthor(@Param("author") String author);
}