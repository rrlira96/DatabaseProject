package com.unicap.bd2.DatabaseProject.Service;

import com.unicap.bd2.DatabaseProject.Entities.Order;
import com.unicap.bd2.DatabaseProject.Repository.OrderRepository;
import com.unicap.bd2.DatabaseProject.Service.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
