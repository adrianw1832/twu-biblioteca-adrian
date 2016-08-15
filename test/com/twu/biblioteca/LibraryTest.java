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
    public void bookCollectionListTest() {
        library.setUpBookCollection();
        library.listBooks();
        String consoleList = outContent.toString();
        assertTrue(consoleList, consoleList.contains("Book1"));
        assertTrue(consoleList, consoleList.contains("Adrian"));
        assertTrue(consoleList, consoleList.contains("2016"));
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
//        assertEquals(false, consoleList.contains(("Book1")));
//        assertEquals(false, consoleList.contains("Adrian"));
//        assertEquals(false, consoleList.contains("2016"));
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
}

