package com.twu.biblioteca;

public class User {
    private String name;
    private String email;
    private String phone;
    private String libraryNumber;
    private int password;

    public User(String name, String email, String phone, String libraryNumber, int password ) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return this.libraryNumber;
    }

    public int getPassword() {
        return this.password;
    }

    public String info() {
        return String.format("%-25s |%-25s |%-25s", this.name, this.email, this.phone);
    }
}
