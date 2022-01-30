package com.gorkem.caseStudy.controller;

import com.gorkem.caseStudy.dao.BookDAO;
import com.gorkem.caseStudy.dao.BookStockDAO;
import com.gorkem.caseStudy.entities.Book;
import com.gorkem.caseStudy.entities.Customer;
import com.gorkem.caseStudy.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/book")
@Api(value = "book-api")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "", notes = "Save book")
    public Book saveBook(@RequestBody BookDAO book){
       return bookService.saveBook(book);
    }

    @RequestMapping(value = "/updateBookStock", method = RequestMethod.PUT)
    @ApiOperation(value = "", notes = "Update Book stock")
    public ResponseEntity updateBookStock(@RequestBody BookStockDAO bookStockDAO){
        return bookService.updateStock(bookStockDAO);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "Get book by id")
    public Book getBook(@ApiParam(required = true) @PathVariable("id") UUID id){
        return bookService.findById(id);
    }

    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "Get all book")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
}
