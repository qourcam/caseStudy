package com.gorkem.caseStudy.entities;

import com.gorkem.caseStudy.EnumBookGenre;
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
    @Field(name = "author")
    private String author;
    @Field(name="genre")
    private EnumBookGenre genre;
    @Field(name = "stock")
    private Integer stock;
    @Field(name = "price")
    private Double price;

    public Book() {
    }

    public Book(String name, String author, EnumBookGenre genre, Integer stock, Double price) {
        this.id=UUID.randomUUID();
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.stock = stock;
        this.price = price;
    }
}
