package com.gorkem.caseStudy.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class OrderDAO {

    private UUID customerId;
    private UUID bookId;
    private Date orderDate;

    private Integer quantity;
}
