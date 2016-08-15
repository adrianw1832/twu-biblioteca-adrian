package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    Movie movie = new Movie("Movie1", "Adrian", 2016, 10);

    @Test
    public void isAvailableTest() {
        assertEquals(true, movie.isAvailable());
    }

    @Test
    public void notAvailableTest() {
        movie.changeAvailability();
        assertEquals(false, movie.isAvailable());
    }

    @Test
    public void isAvailableAgainTest() {
        movie.changeAvailability();
        movie.changeAvailability();
        assertEquals(true, movie.isAvailable());
    }
}
