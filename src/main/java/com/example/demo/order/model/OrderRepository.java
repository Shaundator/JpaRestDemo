package com.example.demo.order.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface OrderRepository extends CrudRepository<Order, Long> {

    Optional<Order> findById(long id);
}