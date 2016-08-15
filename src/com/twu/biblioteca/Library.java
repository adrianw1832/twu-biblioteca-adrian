package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    ArrayList bookCollection = new ArrayList();

    void initialize() {
        callGreeting();
    }

    void callGreeting() {
        System.out.println("Welcome to the library!");
    }

    void setUpBookCollection() {
        Book book1 = new Book("Book1");
        Book book2 = new Book("Book2");
        Book book3 = new Book("Book3");
        bookCollection.add(book1);
        bookCollection.add(book2);
        bookCollection.add(book3);
    }
}
