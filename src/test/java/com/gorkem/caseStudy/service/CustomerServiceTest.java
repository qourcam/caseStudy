package com.gorkem.caseStudy.service;

import com.gorkem.caseStudy.dao.CustomerDAO;
import com.gorkem.caseStudy.exception.PersonalException;
import com.gorkem.caseStudy.factory.TestDAOFactory;
import com.gorkem.caseStudy.factory.TestEntityFactory;
import com.gorkem.caseStudy.repository.CustomerRepository;
import com.gorkem.caseStudy.validation.CustomerValidation;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerValidation customerValidation;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void saveCustomerTestSuccessful(){
        Mockito.when(customerRepository.save(Mockito.any())).thenReturn(TestEntityFactory.customer());
        customerService.save(TestDAOFactory.customerDao());
    }

    @Test
    public void deleteCustomerTestInvalidId(){
        expectedEx.expect(IllegalArgumentException.class);
        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(Optional.of(TestEntityFactory.customer()));
        customerService.delete("Invalid id");
    }

    @Test
    public void deleteCustomerTestSuccessful(){
        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(Optional.of(TestEntityFactory.customer()));
        customerService.delete(UUID.randomUUID().toString());
    }

    @Test
    public void findAllCustomerTestSuccessful(){
        Mockito.when(customerRepository.findAll()).thenReturn(TestEntityFactory.customerList());
        customerService.findAllCustomers();
    }
    @Test
    public void findByIdTestSuccessful(){
        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(Optional.of(TestEntityFactory.customer()));
        customerService.findById(UUID.randomUUID());
    }
    @Test
    public void findByIdTestCustomerNotFound(){
        expectedEx.expect(NullPointerException.class);
        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(null);
        customerService.findById(null);
    }
}
