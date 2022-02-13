package com.gorkem.caseStudy.dao;

import com.gorkem.caseStudy.EnumBookGenre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDAO {

    private String name;
    private String author;
    private EnumBookGenre genre;
    private Integer stock;
    private Double price;
}
