package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, Long> {
    Book findByBookid(long bookid);

    List<Book> findAll();
}
