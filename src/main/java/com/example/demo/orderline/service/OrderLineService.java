package com.example.demo.orderline.service;

import com.example.demo.orderline.model.OrderLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderLineService {
    private final CrudRepository<OrderLine, Long> repository;

    public OrderLineService(CrudRepository<OrderLine, Long> repository) {
        this.repository = repository;
    }

    public Optional<OrderLine> find(Long id) {
        return repository.findById(id);
    }

    public OrderLine create(OrderLine orderLine) {
        return repository.save(orderLine);
    }

    public OrderLine update(Long id, OrderLine orderLine) {
        return repository.save( orderLine);
    }

    public OrderLine delete(Long id) {
        repository.deleteById(id);
        return null;
    }
}