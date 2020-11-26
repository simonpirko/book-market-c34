package by.bookmarket.service;

import by.bookmarket.dao.book.BookDaoDB;
import by.bookmarket.dao.book.InMemoryBookDao;
import by.bookmarket.entity.book.Book;
import by.bookmarket.entity.book.BookStatus;
import by.bookmarket.entity.book.Format;
import by.bookmarket.entity.book.Genre;
import by.bookmarket.entity.user.User;
import by.bookmarket.errors.*;

import java.util.Date;
import java.util.List;

public class BookService {
    private BookDaoDB bookDB = new BookDaoDB();
    private InMemoryBookDao iMBook = new InMemoryBookDao();

    public boolean synchronizedSave(Book book) {
        if (iMBook.contains(book) && bookDB.contains(book)) {
            return false;
        } else {
            iMBook.save(book);
            bookDB.save(book);
        }
        return true;
    }

    public void synchronizedDelete(long id) {
        if (iMBook.contains(id) && bookDB.contains(id)) {
            if (iMBook.getById(id).equals(bookDB.getById(id))) {
                iMBook.delete(id);
                bookDB.delete(id);
                return;
            }
            throw new BookByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdateName(String newName, long id) {
        if (iMBook.contains(id) && bookDB.contains(id)) {
            if (iMBook.getById(id).equals(bookDB.getById(id))) {
                iMBook.updateBookName(newName, id);
                bookDB.updateBookName(newName, id);
                return;
            }
            throw new BookByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdateAuthor(String newAuthor, long id) {
        if (iMBook.contains(id) && bookDB.contains(id)) {
            if (iMBook.getById(id).equals(bookDB.getById(id))) {
                iMBook.updateAuthor(newAuthor, id);
                bookDB.updateAuthor(newAuthor, id);
                return;
            }
            throw new BookByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdateFormat(Format newFormat, long id) {
        if (iMBook.contains(id) && bookDB.contains(id)) {
            if (iMBook.getById(id).equals(bookDB.getById(id))) {
                iMBook.updateFormat(newFormat, id);
                bookDB.updateFormat(newFormat, id);
                return;
            }
            throw new BookByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdatePublisher(String newPublisher, long id) {
        if (iMBook.contains(id) && bookDB.contains(id)) {
            if (iMBook.getById(id).equals(bookDB.getById(id))) {
                iMBook.updatePublisher(newPublisher, id);
                bookDB.updatePublisher(newPublisher, id);
                return;
            }
            throw new BookByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdatePublicationDate(Date newPublicationDate, long id) {
        if (iMBook.contains(id) && bookDB.contains(id)) {
            if (iMBook.getById(id).equals(bookDB.getById(id))) {
                iMBook.updatePublicationDate(newPublicationDate, id);
                bookDB.updatePublicationDate(newPublicationDate, id);
                return;
            }
            throw new BookByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdatePages(int pages, long id) {
        if (iMBook.contains(id) && bookDB.contains(id)) {
            if (iMBook.getById(id).equals(bookDB.getById(id))) {
                iMBook.updatePages(pages, id);
                bookDB.updatePages(pages, id);
                return;
            }
            throw new BookByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdateQuantity(int newQuantity, long id) {
        if (iMBook.contains(id) && bookDB.contains(id)) {
            if (iMBook.getById(id).equals(bookDB.getById(id))) {
                iMBook.updateQuantity(newQuantity, id);
                bookDB.updateQuantity(newQuantity, id);
                return;
            }
            throw new BookByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdateGenre(Genre genre, long id) {
        if (iMBook.contains(id) && bookDB.contains(id)) {
            if (iMBook.getById(id).equals(bookDB.getById(id))) {
                iMBook.updateGenre(genre, id);
                bookDB.updateGenre(genre, id);
                return;
            }
            throw new BookByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdateCost(double newCost, long id) {
        if (iMBook.contains(id) && bookDB.contains(id)) {
            if (iMBook.getById(id).equals(bookDB.getById(id))) {
                iMBook.updateCost(newCost, id);
                bookDB.updateCost(newCost, id);
                return;
            }
            throw new BookByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdateBookStatus(BookStatus bookStatus, long id) {
        if (iMBook.contains(id) && bookDB.contains(id)) {
            if (iMBook.getById(id).equals(bookDB.getById(id))) {
                iMBook.updateBookStatus(bookStatus, id);
                bookDB.updateBookStatus(bookStatus, id);
                return;
            }
            throw new BookByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdateDescription(String newDescription, long id) {
        if (iMBook.contains(id) && bookDB.contains(id)) {
            if (iMBook.getById(id).equals(bookDB.getById(id))) {
                iMBook.updateDescription(newDescription, id);
                bookDB.updateDescription(newDescription, id);
                return;
            }
            throw new BookByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public List<Book> getAllFromInMemory(){
        if (iMBook.getAll().isEmpty()){
            throw new IsEmptyException();
        }
        return iMBook.getAll();
    }

    public List<Book> getAllFromDB(){
        if (bookDB.getAll().isEmpty()){
            throw new IsEmptyException();
        }
        return bookDB.getAll();
    }

    public void synchronize(){
        iMBook.save(bookDB.getAll());
    }

    public Book getByBookNameFromInMemory(String bookName){
        if (iMBook.getByBookName(bookName) == null){
            throw new BookByNameDoesntExist();
        }
        return iMBook.getByBookName(bookName);
    }

    public Book getByIdFromInMemory(long id){
        if (iMBook.getById(id) == null){
            throw new BookByIdDoesntMatch();
        }
        return iMBook.getById(id);
    }
}
