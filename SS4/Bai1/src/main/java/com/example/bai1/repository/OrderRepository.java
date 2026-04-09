package com.example.bai1.repository;

import org.springframework.stereotype.Repository;

@Repository // Đánh dấu đây là một Bean do Spring quản lý
public class OrderRepository {

    public String getAllOrders() {
        return "Danh sach toan bo don hang";
    }

    public String getOrderById(Long id) {
        return "Thong tin don hang voi ID: " + id;
    }
}