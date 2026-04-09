package com.edupath.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration // Báo cho Spring biết đây là file cấu hình Bean
@EnableWebMvc  // Bật các tính năng của Spring MVC (Annotation, Formatter...)
@ComponentScan("com.edupath") // Tự động quét để tìm các @Controller, @Service, @Repository
public class WebConfig {

    // 1. Cấu hình Nguồn giao diện (Template Resolver)
    // Chỉ định thư mục chứa file HTML là /WEB-INF/views/
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html"); // Dùng file .html
        resolver.setCharacterEncoding("UTF-8"); // Fix lỗi hiển thị tiếng Việt
        return resolver;
    }

    // 2. Cấu hình Cỗ máy render Thymeleaf (Template Engine)
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        // Lệnh kích hoạt tính năng Kế thừa Layout của Thymeleaf (Chức năng 1)
        engine.addDialect(new LayoutDialect());
        return engine;
    }

    // 3. Cấu hình Bộ giải quyết giao diện (View Resolver)
    // Trả kết quả (chuỗi HTML đã được Thymeleaf đổ data) về cho trình duyệt
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}