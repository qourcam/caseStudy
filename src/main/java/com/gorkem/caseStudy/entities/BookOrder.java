package com.gorkem.caseStudy.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
//@Entity
@Document
public class BookOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Field(name = "customer_id")
    private UUID customerId;
    @Field(name = "book_id")
    private UUID bookId;
    @Field(name = "order_date")
    private Date orderDate;
    @Field(name = "quantity")
    private Integer quantity;

    public BookOrder(UUID customerId, UUID bookId, Date orderDate, Integer quantity) {
        this.id=UUID.randomUUID();
        this.customerId = customerId;
        this.bookId = bookId;
        this.orderDate = orderDate;
        this.quantity = quantity;
    }
}
