package by.bookmarket.entity.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.GregorianCalendar;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long id;
    private String name;
    private String author;
    private Format format;
    private String publisher;
    private GregorianCalendar publicationDate;
    private int pages;
    private int quantity;
    private List<Genres> genres;
    private double cost;
    private BookStatus bookStatus;
    private String description;




}

