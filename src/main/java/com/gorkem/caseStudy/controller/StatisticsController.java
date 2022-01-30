package com.gorkem.caseStudy.controller;

import com.gorkem.caseStudy.service.BookService;
import com.gorkem.caseStudy.service.CustomerService;
import com.gorkem.caseStudy.service.OrderService;
import com.gorkem.caseStudy.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/statistics")
@Api(value = "statistics-api")
public class StatisticsController {

    private StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping(value = "/totalOrderCount", method = RequestMethod.POST)
    @ApiOperation(value = "", notes = "Returns total count of orders")
    public ResponseEntity getTotalOrderCount(){
        return new ResponseEntity(statisticsService.countOfAllOrders(), HttpStatus.OK);
    }


    @RequestMapping(value = "/totalPurchasedBookCount", method = RequestMethod.POST)
    @ApiOperation(value = "", notes = "Returns total purchased book count")
    public ResponseEntity getTotalPurchasedBookCount(){
        return new ResponseEntity(statisticsService.countOfAllPurchasedBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/totalAmountOfPurchases", method = RequestMethod.POST)
    @ApiOperation(value = "", notes = "Returns total purchased book count")
    public ResponseEntity getTotalAmountOfAllPurchases(){
        return new ResponseEntity(statisticsService.getTotalAmountOfAllPurchases(), HttpStatus.OK);
    }

}
