package com.edupath.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Lớp này thay thế hoàn toàn file cấu hình web.xml truyền thống
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Các cấu hình không liên quan đến Web (như Database Security) - Để trống vì project chưa dùng DB thật
    @Override
    protected Class<?>[] getRootConfigClasses() { return null; }

    // Chỉ định cho Spring biết file cấu hình Web (Controller, View) là file WebConfig.class
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    // Chặn mọi Request (đường dẫn bắt đầu bằng "/") và đẩy cho Spring xử lý
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}