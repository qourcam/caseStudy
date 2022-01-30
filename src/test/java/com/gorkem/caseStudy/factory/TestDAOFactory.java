package com.gorkem.caseStudy.factory;

import com.gorkem.caseStudy.dao.BookDAO;
import com.gorkem.caseStudy.dao.CustomerDAO;

public class TestDAOFactory {


    public static CustomerDAO customerDao(){
        CustomerDAO customer= new CustomerDAO();
        customer.setName("name");
        customer.setEmail("abc@abc.com");
        return customer;
    }

    public static BookDAO bookDAO(){
        BookDAO bookDAO= new BookDAO();
        bookDAO.setName("");
        bookDAO.setPrice(1d);
        bookDAO.setStock(1);
        return bookDAO;
    }
}
