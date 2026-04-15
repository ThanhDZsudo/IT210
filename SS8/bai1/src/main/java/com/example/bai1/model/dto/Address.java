package com.example.bai1.model.dto;

import jakarta.validation.constraints.NotBlank;

public class Address {

    @NotBlank(message = "Tên người nhận không được để trống")
    private String receiverName;

    @NotBlank(message = "Địa chỉ chi tiết không được để trống")
    private String detailedAddress;

    public Address() {}

    // Getters and Setters
    public String getReceiverName() { return receiverName; }
    public void setReceiverName(String receiverName) { this.receiverName = receiverName; }

    public String getDetailedAddress() { return detailedAddress; }
    public void setDetailedAddress(String detailedAddress) { this.detailedAddress = detailedAddress; }
}