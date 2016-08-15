package com.twu.biblioteca;


import org.junit.*;
import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
}

