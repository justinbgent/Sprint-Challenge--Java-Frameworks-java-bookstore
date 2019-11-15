package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.Author;
import com.lambdaschool.usermodel.models.Book;

import java.util.List;

public interface BookStoreService {
    List<Book> getBooks();

    List<Author> getAuthors();

    
}
