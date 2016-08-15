package com.twu.biblioteca;


import org.junit.*;
import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Library library = new Library();

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpSteam() {
        System.setOut(null);
    }

    @Test
    public void welcomeMessageTest() {
        library.callGreeting();
        String consoleGreeting = outContent.toString();
        assertEquals("Welcome to the library!\n", consoleGreeting);
    }

    @Test
    public void bookCollectionSizeTest() {
        library.setUpBookCollection();
        assertEquals(3, library.bookCollection.size());
    }

    @Test
    public void movieCollectionSizeTest() {
        library.setUpMovieCollection();
        assertEquals(2, library.movieCollection.size());
    }

    @Test
    public void bookCollectionListTest() {
        library.setUpBookCollection();
        library.listBooks();
        String consoleList = outContent.toString();
        assertTrue(consoleList.contains("Book1"));
        assertTrue(consoleList.contains("Adrian"));
        assertTrue(consoleList.contains("2016"));
    }

    @Test
    public void movieCollectionListTest() {
        library.setUpMovieCollection();
        library.listMovies();
        String consoleList = outContent.toString();
        assertTrue(consoleList.contains("Movie1"));
        assertTrue(consoleList.contains("Adrian"));
        assertTrue(consoleList.contains("2016"));
        assertTrue(consoleList.contains("10"));
    }

    @Test
    public void checkOutBookSuccessMessageTest() {
        library.setUpBookCollection();
        String message = library.checkOutBook("Book1");
        assertEquals("This book is now checked out. Enjoy!", message);
    }

    @Test
    public void checkOutBookFailureMessageTest() {
        library.setUpBookCollection();
        String message = library.checkOutBook("Book4");
        assertEquals("This book is not available. Sorry!", message);
    }

//    @Test
//    public void checkOutBookNameTest() {
//        library.setUpBookCollection();
//        library.checkOutBook("Book1");
//        library.listBooks();
//        String consoleList = outContent.toString();
//        assertFalse(consoleList.contains(("Book1")));
//        assertFalse(consoleList.contains("Adrian"));
//        assertFalse(consoleList.contains("2016"));
//    }

    @Test
    public void returnBookSuccessMessageTest() {
        library.setUpBookCollection();
        library.checkOutBook("Book1");
        String message = library.returnBook("Book1");
        assertEquals("Thank you for returning the book!", message);
    }

    @Test
    public void returnBookFailureMessageTest() {
        library.setUpBookCollection();
        library.checkOutBook("Book1");
        String message = library.returnBook("Book4");
        assertEquals("That is not a valid book to return.", message);
    }

    @Test
    public void loginSuccessMessageTest() {
        library.setUpUsers();
        String message = library.userLogin("123-4567", 1234);
        assertEquals("You have logged in.", message);
    }

    @Test
    public void loginFailureMessageTest() {
        library.setUpUsers();
        String message = library.userLogin("123-4568", 1234);
        assertEquals("You have not logged in.", message);
    }
}

