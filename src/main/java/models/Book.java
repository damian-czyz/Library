package models;

public class Book {

    private final String title;
    private final String author;
    private final String releaseDate;

    public Book(String title, String author, String releaseDate){
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return  "Title: " + title + "</br>" +
                "Author: " + author + "</br>" +
                "Release date: " + releaseDate;
    }
}
