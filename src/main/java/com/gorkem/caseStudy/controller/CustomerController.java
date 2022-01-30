package com.gorkem.caseStudy.controller;

import com.gorkem.caseStudy.dao.CustomerDAO;
import com.gorkem.caseStudy.entities.Customer;
import com.gorkem.caseStudy.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@Api(value = "customer-api")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "", notes = "Save customer")
    public Customer saveCustomer(@RequestBody CustomerDAO customer){
        return customerService.save(customer);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "Get all customers")
    public List<Customer> getAllCustomers(){
        return customerService.findAllCustomers();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ApiOperation(value = "", notes = "Update customer")
    public ResponseEntity updateCustomer(@RequestBody Customer customer){
        customerService.update(customer);
        return new ResponseEntity("Customer updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "", notes = "Save customer")
    public ResponseEntity deleteCustomer(@ApiParam(required = true) @PathVariable("id") String id){
        customerService.delete(id);
        return new ResponseEntity("Customer deleted successfully", HttpStatus.OK);
    }

}
