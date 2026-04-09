package com.restaurant.bai2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.restaurant.bai2.service.OrderService;

@Controller
public class RestaurantController {

    private final OrderService orderService;

    @Autowired
    public RestaurantController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/bai2/menu")
    @ResponseBody
    public String getMenu(
            // THÊM required = false VÀ defaultValue = "chay"
            @RequestParam(value = "category", required = false, defaultValue = "chay") String category
    ) {
        return "Hệ thống trả về danh sách thực đơn cho loại món: " + category;
    }
}