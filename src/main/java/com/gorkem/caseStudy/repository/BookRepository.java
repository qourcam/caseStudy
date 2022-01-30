package com.gorkem.caseStudy.repository;

import com.gorkem.caseStudy.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

//public interface BookRepository extends CrudRepository<Book, UUID> {
public interface BookRepository extends MongoRepository<Book, UUID> {
}
