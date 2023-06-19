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
                        "\n4. Add book" +
                        "\n5. Delete book" +
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
                addBook();
            } else if (command.equals("5")) {
                deleteBook();
            } else if (command.equals("Q")) {
                break;
            }

        }

    }

    private void deleteBook() {
        System.out.println("Please provide book's ID:");
        int id = scanner.nextInt();
        Book book = bookDAO.getBookById(id);
        bookDAO.deleteBook(book);
    }

    private void addBook() {
        System.out.println("Please provide author's ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Author author = authorDAO.getAuthorById(id);
        Book book = new Book();

        System.out.println("Please provide name of the book:");
        String name = scanner.nextLine();
        System.out.println("Please provide year of the publication:");
        Integer year = scanner.nextInt();
        book.setName(name);
        book.setYearWritten(year);
        book.setAuthor(author);

        bookDAO.addBook(book);
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
