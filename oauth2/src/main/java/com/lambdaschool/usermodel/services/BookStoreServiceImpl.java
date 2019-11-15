package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.Author;
import com.lambdaschool.usermodel.models.Book;
import com.lambdaschool.usermodel.models.Wrote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bookStoreService")
public class BookStoreServiceImpl implements BookStoreService {

    @Override
    public List<Book> getBooks() {
        return null;
    }

    @Override
    public List<Author> getAuthors() {
        return null;
    }

    @Override
    public Book updateBook(long bookid) {
        return null;
    }

    @Override
    public Wrote addWrittenByToBook(long bookid, long authorid) {
        return null;
    }

    @Override
    public void removeBook(long bookid) {

    }
}
