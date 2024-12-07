package com.klef.jfsd.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book updateBook(int bookId, Book book) {
        Book existingBook = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setGenre(book.getGenre());
        existingBook.setPrice(book.getPrice());
        existingBook.setPublishedYear(book.getPublishedYear());
        return bookRepository.save(existingBook);
    }
}
