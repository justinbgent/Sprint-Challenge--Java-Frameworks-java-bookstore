package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.models.Book;
import com.lambdaschool.usermodel.services.BookStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/data")
public class DataController {
    @Autowired
    private BookStoreService service;

    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    // http://localhost:2019/data/books/{bookid}
    @PutMapping(value = "/books/{id}", consumes = "application/json")
    ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody Book book){
        logger.info("books/" + id + " Accessed to Update");
        service.updateBook(id, book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:2019/data/books/{bookid}/authors/{authorid}
    @PostMapping(value = "/books/{bookid}/authors/{authorid}")
    ResponseEntity<?> addWrittenBy(@PathVariable long bookid, @PathVariable long authorid){
        logger.info("books/" + bookid + " /authors/" + authorid +" Accessed");
        service.addWrittenByToBook(bookid, authorid);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // http://localhost:2019/data/books/{bookid}
    @DeleteMapping(value = "/books/{id}")
    ResponseEntity<?> removeBook(@PathVariable long id){
        logger.info("books/" + id + " Accessed to Delete");
        service.removeBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
