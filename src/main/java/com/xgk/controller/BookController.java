package com.xgk.controller;

import com.xgk.pojo.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xgk
 * @date 2022/1/31
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public Book getById() {
        Book book = new Book(1, "aa", "springboot", "very good.");
        System.out.println("getById is running...");
        return book;
    }
}
