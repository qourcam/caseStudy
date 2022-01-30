package com.gorkem.caseStudy.controller;

import com.gorkem.caseStudy.dao.OrderDAO;
import com.gorkem.caseStudy.dao.StartEndTimeDAO;
import com.gorkem.caseStudy.entities.BookOrder;
import com.gorkem.caseStudy.service.OrderService;
import com.gorkem.caseStudy.validation.OrderValidator;
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
@RequestMapping(value = "/order")
@Api(value = "order-api")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "", notes = "Save order")
    public ResponseEntity saveOrder(@RequestBody OrderDAO order) {
        orderService.saveOrder(order);
        return new ResponseEntity("Order saved successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "Get all orders")
    public List<BookOrder> getAllOrders() {
        return orderService.findAllOrders();
    }

    @RequestMapping(value = "/getAllOrdersOfCustomer/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "Get all orders of customer")
    public List<BookOrder> getAllOrdersOfCustomer(@ApiParam(required = true) @PathVariable("id") UUID customerId) {
        return orderService.findOrdersOfCustomer(customerId);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "Get order")
    public BookOrder getOrder(@ApiParam(required = true) @PathVariable("id") UUID id){
        return orderService.findById(id);
    }

    @RequestMapping(value = "/getOrdersByDates", method = RequestMethod.POST)
    @ApiOperation(value = "", notes = "Get orders Between Dates")
    public List<BookOrder>  getOrdersByDates(@RequestBody StartEndTimeDAO dao) {
      return  orderService.findOrdersBetweenDates(dao);
    }

}
