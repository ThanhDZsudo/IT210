package com.example.bai1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bai1.repository.OrderRepository;

@Service // Đánh dấu đây là một Bean tầng Service
public class OrderService {

    private final OrderRepository orderRepository;

    // Sử dụng Constructor Injection thay vì new thủ công
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public String getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }
}