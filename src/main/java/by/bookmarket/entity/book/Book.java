package by.bookmarket.entity.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long id;
    private String name;
    private String author;
    private Format format;
    private String publisher;
    private int publicationDate;
    private int pages;
    private int quantity;
    private Genre genre;
    private double cost;
    private BookStatus bookStatus;
    private String description;

    public Book(String name, String author, Format format, String publisher, int publicationDate, int pages, int quantity, Genre genre, double cost, BookStatus bookStatus, String description) {
        this.name = name;
        this.author = author;
        this.format = format;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.pages = pages;
        this.quantity = quantity;
        this.genre = genre;
        this.cost = cost;
        this.bookStatus = bookStatus;
        this.description = description;
    }
}
