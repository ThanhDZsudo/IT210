package com.bookstore.controller;

import com.bookstore.model.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private List<Book> books;

    public BookController() {
        books = new ArrayList<>();
        books.add(new Book(1, "Nhà giả kim", "Paulo Coelho", 250000));
        books.add(new Book(2, "Tuổi trẻ đáng giá bao nhiêu", "Rosie Nguyễn", 350000));
        books.add(new Book(3, "Đắc Nhân Tâm", "Dale Carnegie", 450000));
        books.add(new Book(4, "Đọc vị bất kỳ ai", "David J. Lieberman", 150000));
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/{id}")
    public String detailBook(@PathVariable("id") int id, Model model) {
        Book foundBook = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("book", foundBook);
        return "book/detail";
    }
}