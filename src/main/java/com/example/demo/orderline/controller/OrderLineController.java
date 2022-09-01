package com.example.demo.orderline.controller;

import com.example.demo.orderline.model.OrderLine;
import com.example.demo.orderline.model.OrderLineRepository;
import com.example.demo.orderline.service.OrderLineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin // Allow all domain origins.
@RestController
@RequestMapping("api/v1/orderlines")
public class OrderLineController {

    private final OrderLineRepository repository;
    private final OrderLineService service;

    public OrderLineController(OrderLineRepository repository, OrderLineService service) {
        this.repository = repository;
        this.service = service;
    }

    /**
     * Handles getting/finding all order lines.
     *
     * @return spaceships
     * @see <a href="http://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/GET">HTTP GET</a>
     */
    @GetMapping
    ResponseEntity<List<OrderLine>> findAll() {
        List<OrderLine> all = (List<OrderLine>) repository.findAll();
        return ResponseEntity.ok().body(all);
    }

    /**
     * Handles getting/finding an order line.
     *
     * @param id
     *
     * @see <a href="http://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/GET">HTTP GET</a>
     */
    @GetMapping("/{id}")
    public ResponseEntity<OrderLine> find(@PathVariable("id") Long id) {
        Optional<OrderLine> item = Optional.of(service.find(id)
                .orElseThrow(() -> new RuntimeException("Order line %d not found.".formatted(id))));
        return ResponseEntity.ok().body(item.get());
    }

    /**
     * Handles posting/creating an order line.
     *
     * @param orderLine
     * @return newly created order line
     * @see <a href="http://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/POST">HTTP POST</a>
     */
    @PostMapping
    public ResponseEntity<OrderLine> create(@Valid @RequestBody OrderLine orderLine) {
        OrderLine item = service.create(orderLine);
        return ResponseEntity.ok().body(item);
    }

    /**
     * Handles putting an order line.
     *
     * @param id
     * @param orderLine
     * @return updated spaceship
     * @see <a href="http://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/PUT">HTTP PUT</a>
     */
    @PutMapping("/{id}")
    public ResponseEntity<OrderLine> put(@PathVariable("id") Long id, @Valid @RequestBody OrderLine orderLine) {
        return ResponseEntity.ok().body(service.update(id, orderLine));
    }

    /**
     * Handles patching an order line.
     *
     * @param id
     * @param orderLine
     * @return updated order
     * @see <a href="http://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/PATCH">HTTP PATCH</a>
     */
    @PatchMapping("/{id}")
    public ResponseEntity<OrderLine> patch(@PathVariable("id") Long id, @Valid @RequestBody OrderLine orderLine) {
        return ResponseEntity.ok().body(service.update(id, orderLine));
    }

    /**
     * Handles deleting an order line.
     *
     * @param id
     * @return a null value order
     * @see <a href="http://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/DELETE">HTTP DELETE</a>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<OrderLine> delete(@PathVariable("id") Long id) {
        service.find(id).orElseThrow(() -> new RuntimeException("Order line %d not found.".formatted(id)));

        OrderLine delete = service.delete(id);
        return ResponseEntity.ok().body(delete);
    }
}