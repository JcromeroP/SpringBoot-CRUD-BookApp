package com.books.bookApp.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.books.bookApp.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
