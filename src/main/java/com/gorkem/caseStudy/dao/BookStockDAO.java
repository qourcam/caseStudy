package com.gorkem.caseStudy.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BookStockDAO {

    private UUID bookId;
    private Integer stock;

    public BookStockDAO(UUID bookId, Integer stock) {
        this.bookId = bookId;
        this.stock = stock;
    }

    public BookStockDAO() {
    }
}
