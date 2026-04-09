package com.example.bai1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.bai1.service.OrderService;

@Controller("legacyControllerBai1")
public class LegacyController {

    private final OrderService orderService;

    // Sử dụng Constructor Injection
    @Autowired
    public LegacyController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Đã thay thế @RequestMapping rườm rà bằng @GetMapping
    @GetMapping({"/","/bai1/orders"})
    @ResponseBody
    public String getAllOrders() {
        return orderService.getAllOrders();
    }

    // Đã thay thế @RequestMapping bằng @GetMapping
    @GetMapping("/bai1/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Thêm hàm PostMapping theo yêu cầu đề bài
    @PostMapping("/bai1/orders")
    @ResponseBody
    public String createOrder() {
        return "Da them mot don hang moi (Mô phỏng PostMapping)";
    }
}