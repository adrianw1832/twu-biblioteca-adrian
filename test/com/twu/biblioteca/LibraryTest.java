package com.twu.biblioteca;


import org.junit.*;
import java.io.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
}
