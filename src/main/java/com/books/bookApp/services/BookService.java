package com.books.bookApp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.books.bookApp.controller.dto.BookDTO;
import com.books.bookApp.entities.Book;
import com.books.bookApp.persistence.BookRepository;
import jakarta.transaction.Transactional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        Iterable<Book> books = bookRepository.findAll();
        return StreamSupport.stream(books.spliterator(), false)
                .map(book -> new BookDTO(
                        book.getTitle(),
                        book.getAuthor(),
                        book.getGender(),
                        book.getYearPublication()))
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(book -> new BookDTO(
                        book.getTitle(),
                        book.getAuthor(),
                        book.getGender(),
                        book.getYearPublication()))
                .orElseThrow(() -> new RuntimeException("Book with id " + id + "no found"));
    }

    public BookDTO createBook(BookDTO bookDTO){
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setGender(bookDTO.getGender());
        book.setYearPublication(bookDTO.getYearPublication());
        bookRepository.save(book);
        return bookDTO;

    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book with id" + id + "no found"));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setGender(bookDTO.getGender());
        book.setYearPublication(bookDTO.getYearPublication());
        bookRepository.save(book);

        return bookDTO;
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book with id" + id + "no found");
        }
        bookRepository.deleteById(id);
    }

}
