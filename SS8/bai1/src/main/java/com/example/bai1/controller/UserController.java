package com.example.bai1.controller;

import com.example.bai1.model.dto.Address;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class UserController {

    @PostMapping("/update")
    // @Valid: "Công tắc" để kích hoạt kiểm tra dữ liệu
    public ResponseEntity<String> updateAddress(@Valid @RequestBody Address addressDto) {

        System.out.println("Log: Đã nhận dữ liệu sạch: " + addressDto.getReceiverName());

        return ResponseEntity.ok("Cập nhật địa chỉ thành công!");
    }
}