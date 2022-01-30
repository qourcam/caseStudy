package com.gorkem.caseStudy.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
//@Entity
@Document
public class Book {

    @Id
    private UUID id;
    @Field(name = "name")
    private String name;
    @Field(name = "stock")
    private Integer stock;
    @Field(name = "price")
    private Double price;

    public Book() {
    }

    public Book(String name, Integer stock, Double price) {
        this.id=UUID.randomUUID();
        this.name = name;
        this.stock = stock;
        this.price = price;
    }
}
