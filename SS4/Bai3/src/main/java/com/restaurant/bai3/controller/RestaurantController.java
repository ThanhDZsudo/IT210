package com.restaurant.bai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestaurantController {

    // Đường dẫn nhận tham số ID trực tiếp trên URL (Cách A)
    @GetMapping("/bai3/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable("id") Long id) {
        return "Chi tiết đơn hàng số " + id;
    }
}