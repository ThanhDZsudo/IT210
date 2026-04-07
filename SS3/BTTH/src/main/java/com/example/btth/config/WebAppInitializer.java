package com.example.btth.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * File này thay thế hoàn toàn cho file cấu hình web.xml truyền thống.
 * Khi Tomcat khởi động, nó sẽ tự động tìm và chạy lớp này để cấu hình Spring MVC.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Cấu hình các Bean dùng chung cho toàn hệ thống (như Database, Security)
        // Hiện tại dự án nhỏ nên để null
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Đăng ký lớp cấu hình chính (AppConfig) cho DispatcherServlet
        // Giúp Spring biết các thiết lập về ViewResolver, ComponentScan...
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // Cấu hình đường dẫn URL mà Spring MVC sẽ tiếp nhận xử lý
        // Dấu "/" nghĩa là Spring sẽ nhận mọi yêu cầu gửi đến ứng dụng
        return new String[]{"/"};
    }
}