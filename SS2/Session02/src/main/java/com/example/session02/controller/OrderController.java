package com.example.session02.controller;

import com.example.session02.model.Order;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    // Tiêm ServletContext để thao tác với Application Scope
    @Autowired
    private ServletContext servletContext;

    @GetMapping("/orders")
    public String showOrders(HttpSession session, Model model) {
        // 1. Kiểm tra đăng nhập (Bẫy dữ liệu #1 & #5)
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        // 2. Tạo danh sách đơn hàng giả (Lưu vào Request Scope qua Model)
        List<Order> orders = Arrays.asList(
                new Order("ORD-001", "Laptop Dell XPS 15", 35000000.0, new Date()),
                new Order("ORD-002", "Chuột Logitech G Pro", 2500000.0, new Date()),
                new Order("ORD-003", "Bàn phím cơ Rainy75", 2800000.0, new Date())
        );
        model.addAttribute("orderList", orders);

        // 3. Cập nhật Application Scope an toàn, chống Race Condition
        synchronized (servletContext) {
            Integer count = (Integer) servletContext.getAttribute("totalViewCount");
            if (count == null) {
                count = 0;
            }
            count++;
            servletContext.setAttribute("totalViewCount", count);
        }

        return "orders"; // Trả về orders.jsp
    }
}