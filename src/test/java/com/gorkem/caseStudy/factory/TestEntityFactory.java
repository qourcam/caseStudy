package com.gorkem.caseStudy.factory;

import com.gorkem.caseStudy.entities.Book;
import com.gorkem.caseStudy.entities.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestEntityFactory {

    public static Customer customer(){
        Customer customer= new Customer();
        customer.setId(UUID.randomUUID());
        customer.setName("name");
        return customer;
    }

    public static List<Customer> customerList(){
        List<Customer> customerList= new ArrayList<>();
        customerList.add(customer());
        return customerList;
    }


    public static Book book(){
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setName("");
        book.setStock(1);
        book.setStock(1);
        return book;
    }

    public static List<Book> bookList(){
        List<Book> bookList= new ArrayList<>();
        bookList.add(book());
        return bookList;
    }
}
