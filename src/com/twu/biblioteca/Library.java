package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> bookCollection = new ArrayList<Book>();

    void initialize() {
        setUpBookCollection();
        callGreeting();
    }

    void callGreeting() {
        System.out.println("Welcome to the library!");
    }

    void setUpBookCollection() {
        Book book1 = new Book("Book1", "Adrian", 2016);
        Book book2 = new Book("Book2", "Bob", 2016);
        Book book3 = new Book("Book3", "Claire", 2016);
        bookCollection.add(book1);
        bookCollection.add(book2);
        bookCollection.add(book3);
    }

    void listBooks() {
        System.out.printf( "%-27s%-27s%-27s", "Title", "Author", "Year Published");
        printInfo(bookCollection);
    }

    private void printInfo(ArrayList<Book> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).info());
        }
    }
}

