package com.sowmya;

import com.sowmya.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContent.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        bookService.addBook("The White Tiger");

    }
}