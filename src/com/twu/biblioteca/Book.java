package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int yearPublished;
    private Boolean available;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.available = true;
    }

    public String getTitle() {
        return this.title;
    }

    public String info() {
        return String.format("%-25s |%-25s |%d", this.title, this.author, this.yearPublished);
    }

    public Boolean isAvailable() {
        return (this.available == true);
    }

    public void changeAvailability() {
        this.available = !this.available;
    }
}
