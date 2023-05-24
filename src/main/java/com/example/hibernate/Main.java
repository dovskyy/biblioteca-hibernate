package com.example.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        UserDAO userDAO = new UserDAOImpl(sessionFactory);

        User user1 = new User();
        user1.setName("John Doe");
        user1.setEmail("john.doe@example.com");

        User user2 = new User();
        user2.setName("Jane Smith");
        user2.setEmail("jane.smith@example.com");

        userDAO.saveUser(user1);
        userDAO.saveUser(user2);

        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            System.out.println(user.getId() + " - " + user.getName() + " - " + user.getEmail());
        }

        sessionFactory.close();
    }
}
