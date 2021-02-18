package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.models.Author;
import com.lambdaschool.usermodel.models.Book;
import com.lambdaschool.usermodel.services.BookStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookStoreService service;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    // http://localhost:2019/books/books
    @GetMapping(value = "/books", produces = "application/json")
    ResponseEntity<?> getBooks(){
        logger.info("books/books Accessed");
        List<Book> books = service.getBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
