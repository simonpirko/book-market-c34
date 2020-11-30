package by.bookmarket.dao.book;

import by.bookmarket.entity.book.Book;
import by.bookmarket.entity.book.BookStatus;
import by.bookmarket.entity.book.Format;
import by.bookmarket.entity.book.Genre;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookDao implements BookDao {
    private static List<Book> books = new ArrayList<>();

    @Override
    public boolean save(Book book) {
        return books.add(book);
    }
    public boolean saveFirst(Book book) {
        return books.add(book);
    }

    public boolean save(List<Book> books){
        return this.books.addAll(books);
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Book getById(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book getByBookName(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean contains(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Book book) {
        for (Book bookFromList : books) {
            if (bookFromList.equals(book)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String updateBookName(String newBookName, long id) {
        getById(id).setName(newBookName);
        return newBookName;
    }

    @Override
    public String updateAuthor(String newAuthor, long id) {
        getById(id).setAuthor(newAuthor);
        return newAuthor;
    }

    @Override
    public Format updateFormat(Format newFormat, long id) {
        getById(id).setFormat(newFormat);
        return newFormat;
    }

    @Override
    public String updatePublisher(String newPublisher, long id) {
        getById(id).setPublisher(newPublisher);
        return newPublisher;
    }

    @Override
    public int updatePublicationDate(int newDate, long id) {
        getById(id).setPublicationDate(newDate);
        return newDate;
    }

    @Override
    public int updatePages(int newPages, long id) {
        getById(id).setPages(newPages);
        return newPages;
    }

    @Override
    public int updateQuantity(int newQuantity, long id) {
        getById(id).setQuantity(newQuantity);
        return newQuantity;
    }

    @Override
    public Genre updateGenre(Genre newGenre, long id) {
        getById(id).setGenre(newGenre);
        return newGenre;
    }

    @Override
    public double updateCost(double newCost, long id) {
        getById(id).setCost(newCost);
        return newCost;
    }

    @Override
    public BookStatus updateBookStatus(BookStatus newBookStatus, long id) {
        getById(id).setBookStatus(newBookStatus);
        return newBookStatus;
    }

    @Override
    public String updateDescription(String newDescription, long id) {
        getById(id).setDescription(newDescription);
        return newDescription;
    }
}
