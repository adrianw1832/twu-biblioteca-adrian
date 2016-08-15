package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    Book book = new Book("Book1", "Adrian", 2016);

    @Test
    public void isAvailableTest() {
        assertEquals(true, book.isAvailable());
    }

    @Test
    public void notAvailableTest() {
        book.changeAvailability();
        assertEquals(false, book.isAvailable());
    }

    @Test
    public void isAvailableAgainTest() {
        book.changeAvailability();
        book.changeAvailability();
        assertEquals(true, book.isAvailable());
    }
}
