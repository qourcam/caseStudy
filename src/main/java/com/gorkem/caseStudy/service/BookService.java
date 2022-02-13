package com.gorkem.caseStudy.service;

import com.gorkem.caseStudy.dao.BookDAO;
import com.gorkem.caseStudy.dao.BookStockDAO;
import com.gorkem.caseStudy.dao.BookNameAuthorDAO;
import com.gorkem.caseStudy.entities.Book;
import com.gorkem.caseStudy.exception.PersonalException;
import com.gorkem.caseStudy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(BookDAO bookDAO) {
        Book book = new Book(bookDAO.getName(), bookDAO.getAuthor(), bookDAO.getGenre(),
                bookDAO.getStock(), bookDAO.getPrice());
        bookRepository.save(book);
        return book;
    }

    public ResponseEntity updateStock(BookStockDAO bookStockDAO) {
        try {
            Book book = bookRepository.findById(bookStockDAO.getBookId()).get();
            book.setStock(bookStockDAO.getStock());
            bookRepository.save(book);
            return new ResponseEntity("Stock of the book updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Problem Occured while updating. Be sure to give correct book id", HttpStatus.BAD_REQUEST);
        }
    }

    public boolean reduceBookStock(BookStockDAO bookStockDAO) {
        try {
            Book book = bookRepository.findById(bookStockDAO.getBookId()).get();
            book.setStock(book.getStock() - bookStockDAO.getStock());
            bookRepository.save(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Book findById(UUID id) {
        return bookRepository.findById(id).orElseThrow(() -> new PersonalException("Book cannot be found"));

    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public int findBooksHasNoStock() {
        List<Book> list = bookRepository.findBooksHasNoStock(0);
        return list.size();
    }

    public List<Book> findByAuthor(String author){
        return  bookRepository.findByAuthorIgnoreCase(author);
    }

    public List<BookNameAuthorDAO> findByGenre(String genre){
        return  bookRepository.getBookNameAndAuthorByGenre(genre);
    }
}
