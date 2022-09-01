package com.example.demo.orderline.model;

import com.example.demo.order.model.Order;
import com.example.demo.product.model.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="ORDERLINES")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="UNITPRICE")
    private Double unitPrice;

    @Column(name="TOTALPRICE")
    private Double totalPrice;

    @Column(name="QUANTITY")
    private Integer quantity;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="ORDER_ID", nullable=false)
    private Order order;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name="PRODUCT_ID", nullable=false)
    Product product;

    public OrderLine(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}