package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.models.Author;
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
@RequestMapping(value = "/authors")
public class AuthorController {
    @Autowired
    private BookStoreService service;

    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    // http://localhost:2019/authors/authors
    @GetMapping(value = "/authors", produces = "application/json")
    ResponseEntity<?> getAuthors(){
        logger.info("authors/authors Accessed");
        List<Author> authors = service.getAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}
