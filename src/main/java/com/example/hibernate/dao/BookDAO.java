package com.example.hibernate.dao;

import com.example.hibernate.model.Author;
import com.example.hibernate.model.Book;

public interface BookDAO {

    void addBook(Book book);
    void deleteBook(Book book);
    Book getBookById(int id);
}
