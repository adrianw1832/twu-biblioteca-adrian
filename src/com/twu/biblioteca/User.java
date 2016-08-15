package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private int password;

    public User(String libraryNumber, int password ) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return this.libraryNumber;
    }

    public int getPassword() {
        return this.password;
    }
}
