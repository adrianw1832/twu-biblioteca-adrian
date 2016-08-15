package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String info() {
        return String.format("%-25s |%-25s |%d", this.title, this.author, this.yearPublished);
    }
}
