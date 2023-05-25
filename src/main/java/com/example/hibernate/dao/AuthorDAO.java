package com.example.hibernate;

import java.util.List;

public interface AuthorDAO {
    void addBook(Book book);
    List<Book> getBooks(Author author);
    void save(Author author);
    void update(Author author);
    void delete(Author author);
    Author getAuthorById(int id);
}
