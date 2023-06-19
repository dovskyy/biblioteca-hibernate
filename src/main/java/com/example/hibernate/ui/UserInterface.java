package com.example.hibernate.ui;

import com.example.hibernate.dao.AuthorDAO;
import com.example.hibernate.dao.AuthorDAOImpl;
import com.example.hibernate.dao.BookDAO;
import com.example.hibernate.dao.BookDAOImpl;
import com.example.hibernate.model.Author;
import com.example.hibernate.model.Book;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private SessionFactory sessionFactory;
    private AuthorDAO authorDAO;
    private BookDAO bookDAO;

    public UserInterface(Scanner scanner, SessionFactory sessionFactory) {
        this.scanner = scanner;
        this.sessionFactory = sessionFactory;
        this.authorDAO = new AuthorDAOImpl(this.sessionFactory);
        this.bookDAO = new BookDAOImpl(this.sessionFactory);
    }

    public void startUi() {
        System.out.println(
                "Welcome to basic library management system:" +
                        "\nSelect what you would like to do:" +
                        "\n1. Add author" +
                        "\n2. Delete author" +
                        "\n3. Get author's books" +
                        "\n4. Add book to the author" +
                        "\nQ. Quit the app"
        );

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("1")) {
                addAuthor();
            } else if (command.equals("2")) {
                deleteAuthor();
            } else if (command.equals("3")) {
                getAuthorsBooks();
            } else if (command.equals("4")) {
                addBookToAuthor();
            } else if (command.equals("Q")) {
                break;
            }

        }

    }

    private void addBookToAuthor() {
        System.out.println("Please provide author's ID:");
        int id = scanner.nextInt();
        Author author = authorDAO.getAuthorById(id);


    }

    private void getAuthorsBooks() {
        System.out.println("Please provide author's ID:");
        int id = scanner.nextInt();
        Author author = authorDAO.getAuthorById(id);
        ArrayList<Book> books = (ArrayList<Book>) authorDAO.getBooks(author);

        for (Book book : books) {
            System.out.println(book);
        }

    }

    private void deleteAuthor() {
        System.out.println("Please provide author's ID:");
        int id = scanner.nextInt();
        Author author = authorDAO.getAuthorById(id);
        authorDAO.delete(author);

    }

    private void addAuthor() {
        System.out.println("Please provide author's name");
        String name = scanner.nextLine();
        Author author = new Author();
        author.setName(name);

        authorDAO.save(author);
    }
}
