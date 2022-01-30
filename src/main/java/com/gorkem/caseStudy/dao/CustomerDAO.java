package com.gorkem.caseStudy.dao;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CustomerDAO {
    private String name;
    private String email;
}
