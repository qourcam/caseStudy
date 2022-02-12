package com.gorkem.caseStudy.service;

import com.gorkem.caseStudy.dao.BookStockDAO;
import com.gorkem.caseStudy.dao.OrderDAO;
import com.gorkem.caseStudy.dao.StartEndTimeDAO;
import com.gorkem.caseStudy.entities.BookOrder;
import com.gorkem.caseStudy.exception.PersonalException;
import com.gorkem.caseStudy.repository.OrderRepository;
import com.gorkem.caseStudy.validation.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {

    private OrderRepository orderRepository;
    private OrderValidator orderValidator;
    private BookService bookService;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderValidator orderValidator, BookService bookService) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
        this.bookService = bookService;
    }

    public void saveOrder(OrderDAO orderDAO) {
        BookOrder order= new BookOrder(orderDAO.getCustomerId(),orderDAO.getBookId(),orderDAO.getOrderDate(),orderDAO.getQuantity());
        orderValidator.validate(order);
        orderRepository.save(order);
        bookService.reduceBookStock(new BookStockDAO(order.getBookId(),order.getQuantity()));
    }

    public List<BookOrder> findAllOrders() {
        return (List<BookOrder>) orderRepository.findAll();
    }

    public long countOfAllOrders(){
        return orderRepository.count();
    }

    public Page<BookOrder> findOrdersOfCustomer(UUID customerId, Pageable pageable) {

        return orderRepository.findByCustomerId(customerId,pageable);
    }

    public BookOrder findById(UUID id) {
        return orderRepository.findById(id).orElseThrow(()-> new PersonalException("Order cannot be found"));
    }

    public List<BookOrder> findOrdersBetweenDates(StartEndTimeDAO dao) {
        orderValidator.dateValidation(dao);
        return orderRepository.findByOrderDateBetween(dao.getStartDate(),dao.getEndDate());
    }
}
