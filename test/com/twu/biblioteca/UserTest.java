package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User user = new User("Adrian", "adrian@test.com", "12345678", "123-4567", 1234);

    @Test
    public void getLibraryNumberTest() {
        String libraryNumber = user.getLibraryNumber();
        assertEquals("123-4567", libraryNumber);
    }

    @Test
    public void getPasswordTest() {
        int password = user.getPassword();
        assertEquals(1234, password);
    }
}
