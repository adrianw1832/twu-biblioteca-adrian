package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private Scanner input = new Scanner(System.in);

    ArrayList<Book> bookCollection = new ArrayList<Book>();

    void initialize() {
        setUpBookCollection();
        callGreeting();
        setUpMenu();
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

    void setUpMenu() {
            System.out.println("-- Actions --");
            System.out.println(
                    "Select an option: \n" +
                            " 1) List Books\n" +
                            " 2) Quit\n"
            );

            int selection = input.nextInt();
            input.nextLine();

            switch (selection) {
                case 1:
                    listBooks();
                    setUpMenu();
                    break;
                case 2:
                    System.out.println("See you!");
                    break;
                default:
                    System.out.println("Select a valid option!");
                    setUpMenu();
                    break;
            }

    }
}

