package ru.skillbox;

public class Book {
    private final String name;
    private final String author;
    private final int pages;
    private final String isbn;

    public Book(String name, String author, int pages, String isbn) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }
}
