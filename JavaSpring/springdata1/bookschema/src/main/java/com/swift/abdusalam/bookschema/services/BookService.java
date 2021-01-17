package com.swift.abdusalam.bookschema.services;

import com.swift.abdusalam.bookschema.models.Book;
import com.swift.abdusalam.bookschema.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        Book book= findBook(id);
        if(book != null) {
            book.setTitle(title);
            book.setDescription(desc);
            book.setLanguage(lang);
            book.setNumberOfPages(numOfPages);
            bookRepository.save(book);
            return book;
        } else {
            return null;
        }
    }

    public void deleteBook(Long id) {
        Book book= findBook(id);
        if(book != null) {
            bookRepository.deleteById(id);
        }
    }

    public void updateBook(Book book) {
        Book editedBook = bookRepository.findById(book.getId()).orElse(null);
        assert editedBook != null;
        editedBook.setTitle(book.getTitle());
        editedBook.setDescription(book.getDescription());
        editedBook.setLanguage(book.getLanguage());
        editedBook.setNumberOfPages(book.getNumberOfPages());
        bookRepository.save(editedBook);
    }

}
