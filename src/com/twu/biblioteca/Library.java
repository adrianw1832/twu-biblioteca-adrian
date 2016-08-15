package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private Scanner input = new Scanner(System.in);
    User matchedUser = null;

    ArrayList<Book> bookCollection = new ArrayList<Book>();
    ArrayList<Movie> movieCollection = new ArrayList<Movie>();
    ArrayList<User> userCollection = new ArrayList<User>();

    void initialize() {
        setUpBookCollection();
        setUpMovieCollection();
        setUpUsers();
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

    void setUpMovieCollection() {
        Movie movie1 = new Movie("Movie1", "Adrian", 2016, 10);
        Movie movie2 = new Movie("Movie2", "Bob", 2016, 1);
        movieCollection.add(movie1);
        movieCollection.add(movie2);
    }

    void setUpUsers() {
        User user1 = new User("Adrian", "adrian@test.com", "12345678", "123-4567", 1234);
        User user2 = new User("Bob", "bob@test.com", "23456789", "123-4568", 2345);
        userCollection.add(user1);
        userCollection.add(user2);
    }

    Movie findMovie(String movieName) {
        Movie matchedMovie = null;
        Movie currentMovie;
        for (int i = 0; i < movieCollection.size(); i++) {
            currentMovie = movieCollection.get(i);
            if (currentMovie.getTitle().equals(movieName)) {
                matchedMovie = currentMovie;
            }
        }
        return matchedMovie;
    }

    String userLogin(String libraryNumber, int password) {
        User currentUser;
        for (int i = 0; i < userCollection.size(); i++ ) {
            currentUser = userCollection.get(i);
            if (currentUser.getLibraryNumber().equals(libraryNumber) && currentUser.getPassword() == password) {
                matchedUser = currentUser;
                return "You have logged in.";
            }
        }
        return "You have not logged in.";
    }

    void listBooks() {
        System.out.printf("%-27s%-27s%-27s", "Title", "Author", "Year Published");
        System.out.println();
        printBookInfo(bookCollection);
    }

    void listMovies() {
        System.out.printf("%-27s%-27s%-27s%-27s", "Title", "Director", "Year Made", "Rating");
        System.out.println();
        printMovieInfo(movieCollection);
    }

    private void printBookInfo(ArrayList<Book> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isAvailable()) {
                System.out.println(list.get(i).info());
            }
        }
    }

    private void printMovieInfo(ArrayList<Movie> list) {
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

    String checkOutMovie(String movieName) {
        Movie matchedMovie = findMovie(movieName);
        if (matchedMovie != null && matchedMovie.isAvailable()) {
            matchedMovie.changeAvailability();
            return "This movie is now checked out. Enjoy!";
        } else {
            return "This movie is not available. Sorry!";
        }
    }

    void loginPrompt() {
        while (matchedUser == null) {
            System.out.println("Please enter your library number:");
            String libraryNumber = input.nextLine();
            System.out.println("Please enter your password:");
            int password = Integer.parseInt(input.nextLine());
            System.out.println(userLogin(libraryNumber, password));
        }
    }

    void userInfo() {
        System.out.printf("%-27s%-27s%-27s", "Name", "Email", "Phone");
        System.out.println();
        System.out.println(matchedUser.info());
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
                            " 4) List Movies\n" +
                            " 5) Check Out Movies\n" +
                            " 6) User Info\n" +
                            " 7) Quit\n"
            );

            int selection = input.nextInt();
            input.nextLine();

            switch (selection) {
                case 1:
                    listBooks();
                    break;
                case 2:
                    loginPrompt();
                    System.out.println("Please enter the name of the book!");
                    String userInput = input.nextLine();
                    String message = checkOutBook(userInput);
                    System.out.println(message);
                    break;
                case 3:
                    loginPrompt();
                    System.out.println("Please enter the name of the book!");
                    String userInput1 = input.nextLine();
                    String message1 = returnBook(userInput1);
                    System.out.println(message1);
                    break;
                case 4:
                    listMovies();
                    break;
                case 5:
                    System.out.println("Please enter the name of the movie!");
                    String userInput2 = input.nextLine();
                    String message2 = checkOutMovie(userInput2);
                    System.out.println(message2);
                    break;
                case 6:
                    loginPrompt();
                    userInfo();
                    break;
                case 7:
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

