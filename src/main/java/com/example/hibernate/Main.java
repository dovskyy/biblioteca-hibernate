package com.example.hibernate;


import com.example.hibernate.dao.AuthorDAO;
import com.example.hibernate.dao.AuthorDAOImpl;
import com.example.hibernate.dao.UserDAO;
import com.example.hibernate.dao.UserDAOImpl;
import com.example.hibernate.model.Author;
import com.example.hibernate.ui.UserInterface;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();


        UserInterface userInterface = new UserInterface(new Scanner(System.in), sessionFactory);
        userInterface.startUi();


    }
}
