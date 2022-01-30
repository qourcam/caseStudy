package com.gorkem.caseStudy.validation;

import com.gorkem.caseStudy.dao.CustomerDAO;
import com.gorkem.caseStudy.exception.PersonalException;
import com.gorkem.caseStudy.util.ProjectConstants;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidation {

    private static final String EMAIL_ADDRESS_DATA_TYPE = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.[A-Za-z0-9.-]+$";

    public boolean validate(CustomerDAO customerDAO){

        if(!customerDAO.getEmail().matches(EMAIL_ADDRESS_DATA_TYPE)){
            throw new PersonalException("Email address is not valid");
        }
        return true;
    }
}
