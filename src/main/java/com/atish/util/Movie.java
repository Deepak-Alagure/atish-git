package com.atish.util;

public class Movie implements Comparable<Movie>{
    private String name;
    private int rating;
    private int year;

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public Movie(String name, String rating, String year) {
        this.name = name;
        this.rating = Integer.parseInt(rating);
        this.year = Integer.parseInt(year);
    }


    @Override
    public int compareTo(Movie o) {

        return this.name.compareTo(o.name);
    }
}
