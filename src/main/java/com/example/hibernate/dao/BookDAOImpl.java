package com.example.hibernate.dao;

import com.example.hibernate.dao.BookDAO;
import org.hibernate.SessionFactory;

public class BookDAOImpl implements BookDAO {
    private final SessionFactory sessionFactory;

    public BookDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
