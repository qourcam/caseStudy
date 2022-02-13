package com.gorkem.caseStudy.repository;

import com.gorkem.caseStudy.dao.BookNameAuthorDAO;
import com.gorkem.caseStudy.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends MongoRepository<Book, UUID> {


    //@Query("{stock : {$lt: ?0}}")      // where pages<?
    //@Query("{ stock : { $gte: ?0 } }") // where pages>=?
    @Query("{stock :?0}")
    List<Book> findBooksHasNoStock(int stock);

    //@Query(value = "{author:?0}", sort= "{name:1}") //ASC
    //@Query(value = "{author:?0}", sort= "{name:-1}") //DESC
    List<Book> findByAuthorIgnoreCase(String author);

    //@Query("{$or :[{author: ?0},{genre: ?1}] }")
    @Query("{$and :[{author: ?0},{genre: ?1}] }")
    List<Book> findByAuthorAndGenre(String author, String genre);



    //------------------- @Query with Projection ---------------------------------------
    @Query(value= "{genre: ?0}", fields="{name:1, author:1}") // only name & author  will be displayed
    List<BookNameAuthorDAO> getBookNameAndAuthorByGenre(String genre);
}
