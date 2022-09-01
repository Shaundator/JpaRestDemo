package com.example.demo.product.model;

import com.example.demo.order.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Order> findById(long id);
}