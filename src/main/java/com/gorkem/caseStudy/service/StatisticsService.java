package com.gorkem.caseStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
public class StatisticsService {

    private BookService bookService;
    private OrderService orderService;
    private CustomerService customerService;

    @Autowired
    public StatisticsService(BookService bookService, OrderService orderService, CustomerService customerService) {
        this.bookService = bookService;
        this.orderService = orderService;
        this.customerService = customerService;
    }

    public long countOfAllOrders() {
        return orderService.countOfAllOrders();
    }

    public long countOfAllPurchasedBooks() {
        return orderService.findAllOrders().stream().mapToLong(o->o.getQuantity()).sum();
//        return orderService.countOfAllBooks();
    }

    public Double getTotalAmountOfAllPurchases() {
        AtomicReference<Double> totalAmount = new AtomicReference<>(0d);
        orderService.findAllOrders().forEach(order -> {
            totalAmount.updateAndGet(v -> v + bookService.findById(order.getBookId()).getPrice() * order.getQuantity());
        });
        return totalAmount.get();
    }

}
