package com.sowmya.repository;

public class BookRepositoryImp implements BookRepository {
    @Override
    public void save(String bookTitle) {
        System.out.println("Saving book: " + bookTitle);
    }
}