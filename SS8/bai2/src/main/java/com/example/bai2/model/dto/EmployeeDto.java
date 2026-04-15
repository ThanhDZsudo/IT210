package com.example.bai2.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Employee{

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Định dạng email không hợp lệ")
    private String email;

    @Min(value = 18, message = "Nhân viên phải từ 18 tuổi trở lên")
    @Max(value = 60, message = "Nhân viên không được quá 60 tuổi")
    private int age;

    public Employee() {}

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}