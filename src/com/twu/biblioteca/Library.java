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
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isAvailable()) {
                System.out.println(list.get(i).info());
            }
        }
    }

    Book findBook(String bookName) {
        Book matchedBook = null;
        Book currentBook;
        for (int i = 0; i < bookCollection.size(); i++) {
            currentBook = bookCollection.get(i);
            if (currentBook.getTitle().equals(bookName)) {
                matchedBook = currentBook;
            }

        }
        return matchedBook;
    }

    String checkOutBook(String bookName) {
        Book matchedBook = findBook(bookName);
        if (matchedBook != null && matchedBook.isAvailable()) {
            matchedBook.changeAvailability();
            return "This book is now checked out. Enjoy!";
        } else {
            return "This book is not available. Sorry!";
        }
    }

    String returnBook(String bookName) {
        Book matchedBook = findBook(bookName);
        if (matchedBook != null && !matchedBook.isAvailable()) {
            matchedBook.changeAvailability();
            return "Thank you for returning the book!";
        } else {
            return "That is not a valid book to return.";
        }
    }

    void setUpMenu() {
        Boolean inUse = true;

        while (inUse) {
            System.out.println("-- Actions --");
            System.out.println(
                    "Select an option: \n" +
                            " 1) List Books\n" +
                            " 2) Check Out Books\n" +
                            " 3) Return Books\n" +
                            " 4) Quit\n"
            );

            int selection = input.nextInt();
            input.nextLine();

            switch (selection) {
                case 1:
                    listBooks();
                    break;
                case 2:
                    System.out.println("Please enter the name of the book!");
                    String userInput = input.nextLine();
                    String message = checkOutBook(userInput);
                    System.out.println(message);
                    break;
                case 3:
                    System.out.println("Please enter the name of the book!");
                    String userInput1 = input.nextLine();
                    String message1 = returnBook(userInput1);
                    System.out.println(message1);
                    break;
                case 4:
                    System.out.println("See you!");
                    inUse = false;
                    break;
                default:
                    System.out.println("Select a valid option!");
                    break;
            }
        }
    }
}

