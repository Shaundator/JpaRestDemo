package com.example.demo.order.service;

import com.example.demo.order.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final CrudRepository<Order, Long> repository;

    public OrderService(CrudRepository<Order, Long> repository) {
        this.repository = repository;
    }

    public Optional<Order> find(Long id) {
        return repository.findById(id);
    }

    public Order create(Order order) {
        return repository.save(order);
    }

    public Order update(Long id, Order order) {
        return repository.save( order);
    }

    public Order delete(Long id) {
        repository.deleteById(id);
        return null;
    }
}