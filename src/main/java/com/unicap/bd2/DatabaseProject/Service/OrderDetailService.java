package com.unicap.bd2.DatabaseProject.Service;

import com.unicap.bd2.DatabaseProject.Entities.OrderDetail;
import com.unicap.bd2.DatabaseProject.Entities.OrderDetailPK;
import com.unicap.bd2.DatabaseProject.Repository.OrderDetailRepository;
import com.unicap.bd2.DatabaseProject.Service.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getAllOrdersDetail() {
        return orderDetailRepository.findAll();
    }

    public OrderDetail getOrderDetailById(int orderId, int productId) {
        OrderDetailPK orderDetailPK = new OrderDetailPK(orderId, productId);
        Optional<OrderDetail> order = orderDetailRepository.findById(orderDetailPK);
        return order.orElseThrow(() -> new ResourceNotFoundException(orderDetailPK)); //todo
    }

    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        OrderDetailPK orderDetailPK = new OrderDetailPK(orderDetail.getOrder().getOrderId(), orderDetail.getProduct().getProductID());
        orderDetail.setOrderDetailPK(orderDetailPK);
        return orderDetailRepository.save(orderDetail);
    }
}
