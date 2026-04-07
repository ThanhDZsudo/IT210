package com.example.btth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // Đánh dấu lớp này là lớp cấu hình thay thế cho file XML truyền thống
@EnableWebMvc // Kích hoạt các tính năng mặc định của Spring MVC (như xử lý @Controller, @RequestMapping)
@ComponentScan(basePackages = "com.example.btth") // Chỉ định gói cơ sở để Spring quét và quản lý các Bean (@Controller, @Service, @Repository)
public class AppConfig implements WebMvcConfigurer {

    @Bean // Khai báo một Bean để Spring IoC container quản lý
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        // Cấu hình đường dẫn gốc chứa các file giao diện (JSP)
        resolver.setPrefix("/WEB-INF/views/");

        // Cấu hình đuôi file mặc định cho các View
        resolver.setSuffix(".jsp");

        return resolver;
    }
}