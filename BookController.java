package com.klef.jfsd.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }
}
