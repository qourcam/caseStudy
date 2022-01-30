package com.gorkem.caseStudy.repository;

import com.gorkem.caseStudy.entities.BookOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface OrderRepository extends MongoRepository<BookOrder, UUID> {

    List<BookOrder> findByCustomerId(UUID customerId);

    List<BookOrder> findByOrderDateBetween(Date startDate, Date endDate);

//    @Query("SELECT SUM(quantity) FROM BookOrder")
//    @Aggregation({ $sum: <quantity> })
//    Long countOfAllPurchasedBooks();
}
