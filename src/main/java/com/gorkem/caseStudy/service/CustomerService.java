package com.gorkem.caseStudy.service;

import com.gorkem.caseStudy.dao.CustomerDAO;
import com.gorkem.caseStudy.entities.Customer;
import com.gorkem.caseStudy.exception.PersonalException;
import com.gorkem.caseStudy.repository.CustomerRepository;
import com.gorkem.caseStudy.validation.CustomerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerValidation customerValidation;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerValidation customerValidation) {
        this.customerRepository = customerRepository;
        this.customerValidation = customerValidation;
    }

    public Customer save(CustomerDAO customerDAO){
        customerValidation.validate(customerDAO);
        Customer customer= new Customer(customerDAO.getName(),customerDAO.getEmail());
        customerRepository.save(customer);
        return customer;
    }

    public String update(Customer customer){
        customerRepository.save(customer);
        return customer.getId().toString();
    }

    public void delete(String id){
        Customer customer = customerRepository.findById(UUID.fromString(id)).orElseThrow(()->
                new PersonalException("Customer could not be found"));
        customerRepository.delete(customer);
    }

    public List<Customer> findAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer findById(UUID id){
        Optional<Customer> customer=customerRepository.findById(id);
        return customer.isPresent() ? customer.get() : null;
    }
}
