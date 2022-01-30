package com.gorkem.caseStudy.factory;

import com.gorkem.caseStudy.entities.Book;
import com.gorkem.caseStudy.entities.Customer;

import java.util.UUID;

public class TestEntityFactory {

    public static Customer customer(){
        Customer customer= new Customer();
        customer.setId(UUID.randomUUID());
        customer.setName("name");
        return customer;
    }

    public static Book book(){
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setName("");
        book.setStock(1);
        book.setStock(1);
        return book;
    }
}
