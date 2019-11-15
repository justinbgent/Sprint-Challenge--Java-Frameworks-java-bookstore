package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface AuthorRepo extends CrudRepository<Author, Long> {
    List<Author> findAll();

    Author findByAuthorid(long authorid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Wrote(bookid, authorid) VALUES(:bookid, :authorid)", nativeQuery = true)
    void insertBookAuthorRelation(long bookid, long authorid);
}
