package com.unicap.bd2.DatabaseProject.Controller;


import com.unicap.bd2.DatabaseProject.Entities.Order;
import com.unicap.bd2.DatabaseProject.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Optional<Order> order = Optional.ofNullable(orderService.getOrderById(id));
        return order.isPresent() ? ResponseEntity.ok().body(order.get()) : ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order obj) {
        Optional<Order> order = Optional.ofNullable(orderService.createOrder(obj));
        return order.isPresent() ? ResponseEntity.ok().body(order.get()) : ResponseEntity.badRequest().build();
    }

}
