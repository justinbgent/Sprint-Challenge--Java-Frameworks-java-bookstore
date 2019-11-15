package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.exceptions.ResourceFoundException;
import com.lambdaschool.usermodel.exceptions.ResourceNotFoundException;
import com.lambdaschool.usermodel.models.Author;
import com.lambdaschool.usermodel.models.Book;
import com.lambdaschool.usermodel.models.Wrote;
import com.lambdaschool.usermodel.repository.AuthorRepo;
import com.lambdaschool.usermodel.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service(value = "bookStoreService")
public class BookStoreServiceImpl implements BookStoreService {
    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    BookRepo bookRepo;

    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }

    @Transactional
    @Override
    public Book updateBook(long bookid, Book newBook) {
        Book currentBook = bookRepo.findByBookid(bookid);

        if (newBook.getTitle() != null){
            currentBook.setTitle(newBook.getTitle());
        }

        if (newBook.copyHasValue){
            currentBook.setCopy(newBook.getCopy());
        }

        if (newBook.getISBN() != null){
            currentBook.setISBN(newBook.getISBN());
        }

        if (newBook.getSection() != null){
            currentBook.setSection(newBook.getSection());
        }

        if (newBook.getWriters().size() != 0){
            throw new ResourceFoundException("Writers are not assigned here. Go to /data/books/{bookid}/authors/{authorid} to add writers.");
        }
        if (newBook.getAuthors().size() != 0){
            throw new ResourceFoundException("Writers are not assigned here. Go to /data/books/{bookid}/authors/{authorid} to add writers.");
        }

        return bookRepo.save(currentBook);
    }

    @Transactional
    @Override
    public void addWrittenByToBook(long bookid, long authorid) {
        Book book = bookRepo.findByBookid(bookid);
        Author author = authorRepo.findByAuthorid(authorid);

        if (book.getTitle() != null && author.getFname() != null){
            authorRepo.insertBookAuthorRelation(bookid, authorid);
        }else {
            throw new ResourceNotFoundException("Book or Author ID Doesn't Exist");
        }

    }

    @Transactional
    @Override
    public void removeBook(long bookid) {
        Book book = bookRepo.findByBookid(bookid);

        if (book.getTitle() != null){
            bookRepo.delete(book);
        }else{
            throw new ResourceNotFoundException("Book ID Does not Exist");
        }
    }
}
