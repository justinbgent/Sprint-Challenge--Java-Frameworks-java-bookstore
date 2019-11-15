package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.Author;
import com.lambdaschool.usermodel.models.Book;
import com.lambdaschool.usermodel.models.Wrote;

import java.util.List;

public interface BookStoreService {
    List<Book> getBooks();

    List<Author> getAuthors();

    Book updateBook(long bookid);

    Wrote addWrittenByToBook(long bookid, long authorid);

    void removeBook(long bookid);
}
