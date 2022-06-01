package com.unicap.bd2.DatabaseProject.Controller;


import com.unicap.bd2.DatabaseProject.Entities.OrderDetail;
import com.unicap.bd2.DatabaseProject.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ordersDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAllOrdersDetail() {
        return ResponseEntity.ok().body(orderDetailService.getAllOrdersDetail());
    }

    @GetMapping("/order/{orderId}/product/{productId}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable int orderId, @PathVariable int productId) {
        Optional<OrderDetail> orderDetail = Optional.ofNullable(orderDetailService.getOrderDetailById(orderId, productId));
        return orderDetail.isPresent() ? ResponseEntity.ok().body(orderDetail.get()) : ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<OrderDetail> addOrderDetail(@RequestBody OrderDetail obj) {
        Optional<OrderDetail> orderDetail = Optional.ofNullable(orderDetailService.createOrderDetail(obj));
        return orderDetail.isPresent() ? ResponseEntity.ok().body(orderDetail.get()) : ResponseEntity.badRequest().build();
    }

}
