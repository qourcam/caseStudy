package com.gorkem.caseStudy.validation;

import com.gorkem.caseStudy.entities.BookOrder;
import com.gorkem.caseStudy.exception.PersonalException;
import com.gorkem.caseStudy.service.BookService;
import com.gorkem.caseStudy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {

    private BookService bookService;
    private CustomerService customerService;

    @Autowired
    public OrderValidator(BookService bookService, CustomerService customerService) {
        this.bookService = bookService;
        this.customerService = customerService;
    }

    public boolean validate(BookOrder order) {

        if(customerService.findById(order.getCustomerId())==null){
            throw new PersonalException("Customer cannot be found!");
        }
        if(bookService.findById(order.getBookId())==null){
            throw new PersonalException("Book cannot be found!");
        }
        if(bookService.findById(order.getBookId()).getStock()< order.getQuantity()){
            throw new PersonalException("Limited stock! There are not enough books to be purchased.");
        }

        return true;
    }
}
