package com.gorkem.caseStudy.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
//@Entity
@Document
public class Customer {

    @Id
    private UUID id;

    @Field(name = "name")
    @Indexed(unique = true)
    @NotNull(message = "Name cannot be null!")
    private String name;
    @Field(name = "email")
    @Indexed(unique = true)
    private String email;
    @Field(name = "address")
    private String address;

    public Customer() {
    }

    public Customer(String name,String email) {
        this.id=UUID.randomUUID();
        this.name = name;
        this.email=email;
    }
}
