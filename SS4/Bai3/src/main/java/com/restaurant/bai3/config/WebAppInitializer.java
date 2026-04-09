package com.restaurant.bai3.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { return null; }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{AppConfig.class}; // Trỏ vào file cấu hình ở trên
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}