package by.bookmarket.dao.book;


import by.bookmarket.entity.book.Book;
import by.bookmarket.entity.book.BookStatus;
import by.bookmarket.entity.book.Format;
import by.bookmarket.entity.book.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDaoDB implements BookDao {
    Connection connection;

    {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookMarket", "postgres", "root");
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public boolean save(Book book) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into books values (default,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, String.valueOf(book.getFormat()));
            preparedStatement.setString(4, book.getPublisher());
            preparedStatement.setInt(5, book.getPublicationDate());
            preparedStatement.setInt(6, book.getPages());
            preparedStatement.setString(7, String.valueOf(book.getGenre()));
            preparedStatement.setDouble(8, book.getCost());
            preparedStatement.setString(9, String.valueOf(book.getBookStatus()));
            preparedStatement.setString(10, book.getDescription());
            preparedStatement.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from books");
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                Format format =  Format.valueOf(resultSet.getString(4));
                String publisher = resultSet.getString(5);
                int date = resultSet.getInt(6);
                int pages = resultSet.getInt(7);
                Genre genre = Genre.valueOf(resultSet.getString(8));
                double coast = resultSet.getDouble(9);
                BookStatus bookStatus = BookStatus.valueOf(resultSet.getString(10));
                String description = resultSet.getString(11);
                Book book = new Book(id, name, author, format, publisher, date, pages, genre, coast, bookStatus, description);
                books.add(book);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return books;
    }

    @Override
    public Book getById(long id) {
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from books where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
                long bookId = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                Format format = Format.valueOf(resultSet.getString(4));
                String publisher = resultSet.getString(5);
                int date = resultSet.getInt(6);
                int pages = resultSet.getInt(7);
                Genre genre = Genre.valueOf(resultSet.getString(8));
                double coast = resultSet.getDouble(9);
                BookStatus bookStatus = BookStatus.valueOf(resultSet.getString(10));
                String description = resultSet.getString(11);
                book = new Book(bookId, name, author, format, publisher, date, pages, genre, coast, bookStatus, description);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }

    @Override
    public Book getByBookName(String bookName) {
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from books where name = ?");
            preparedStatement.setString(1, bookName);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long bookId = resultSet.getLong(1);
            String name = resultSet.getString(2);
            String author = resultSet.getString(3);
            Format format =  Format.valueOf(resultSet.getString(4));
            String publisher = resultSet.getString(5);
            int date = resultSet.getInt(6);
            int pages = resultSet.getInt(7);
            Genre genre = Genre.valueOf(resultSet.getString(8));
            double coast = resultSet.getDouble(9);
            BookStatus bookStatus = BookStatus.valueOf(resultSet.getString(10));
            String description = resultSet.getString(11);
            book = new Book(bookId, name, author, format, publisher, date, pages, genre, coast, bookStatus, description);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }

    @Override
    public boolean contains(Book book) {
        List<Book> books = getAll();
        for (int i = 0; i < books.size(); i++) {
            if (book.equals(books.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(long id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id from books");
            while (resultSet.next()) {
                if (resultSet.getLong(1) == id) {
                    return true;
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from books where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException throwable) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwable.printStackTrace();
        }
        return false;
    }

    @Override
    public String updateBookName(String newBookName, long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update books set name = ? where id = ?");
            preparedStatement.setString(1, newBookName);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return newBookName;
    }

    @Override
    public String updateAuthor(String newAuthor, long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update books set author = ? where id = ?");
            preparedStatement.setString(1, newAuthor);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return newAuthor;
    }

    @Override
    public Format updateFormat(Format newFormat, long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update books set format = ? where id = ?");
            preparedStatement.setString(1, String.valueOf(newFormat));
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return newFormat;
    }

    @Override
    public String updatePublisher(String newPublisher, long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update books set publisher = ? where id = ?");
            preparedStatement.setString(1, newPublisher);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return newPublisher;
    }

    @Override
    public int updatePublicationDate (int newDate, long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update books set publishdate = ? where id = ?");
            preparedStatement.setInt(1, newDate);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return newDate;
    }

    @Override
    public int updatePages(int newPages, long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update books set pages = ? where id = ?");
            preparedStatement.setInt(1, newPages);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return newPages;
    }

    @Override
    public Genre updateGenre(Genre newGenre, long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update books set genre = ? where id = ?");
            preparedStatement.setString(1, String.valueOf(newGenre));
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return newGenre;
    }

    @Override
    public double updateCost(double newCost, long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update books set cost = ? where id = ?");
            preparedStatement.setDouble(1, newCost);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return newCost;
    }

    @Override
    public BookStatus updateBookStatus(BookStatus newBookStatus, long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update books set bookstatus = ? where id = ?");
            preparedStatement.setString(1, String.valueOf(newBookStatus));
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return newBookStatus;
    }

    @Override
    public String updateDescription(String newDescription, long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update books set description = ? where id = ?");
            preparedStatement.setString(1, newDescription);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return newDescription;
    }
}
