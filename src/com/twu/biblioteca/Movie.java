package com.twu.biblioteca;

public class Movie {
    private String title;
    private String director;
    private int yearMade;
    private int rating;
    private Boolean available;

    public Movie(String title, String director, int yearMade, int rating) {
        this.title = title;
        this.director = director;
        this.yearMade = yearMade;
        this.rating = rating;
        this.available = true;
    }

    public String getTitle() {
        return this.title;
    }

    public String info() {
        return String.format("%-25s |%-25s |%-25s |%d", this.title, this.director, this.yearMade, this.rating);
    }

    public Boolean isAvailable() {
        return (this.available == true);
    }

    public void changeAvailability() {
        this.available = !this.available;
    }
}
