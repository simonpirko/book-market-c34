package by.bookmarket.dao.order;

import by.bookmarket.dao.book.BookDaoDB;
import by.bookmarket.dao.user.UserDaoDB;
import by.bookmarket.entity.book.Book;
import by.bookmarket.entity.order.Order;
import by.bookmarket.entity.order.OrderStatus;
import by.bookmarket.entity.user.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoDB implements OrderDao {
    Connection connection;
    UserDaoDB userDaoDB;
    BookDaoDB bookDaoDB;

    {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookMarket", "postgres", "1111");
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public boolean save(Order order) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into orders values(default ,?,?,?) RETURNING id");
            preparedStatement.setInt(1, order.getPositions());
            preparedStatement.setLong(2, order.getUser().getId());
            preparedStatement.setString(3, order.getOrderStatus().name());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt(1);
            List<Book> book = order.getBook();
            for (Book books : book) {
                PreparedStatement preparedStatement1 = connection.prepareStatement("insert into order_books values (?,?)");
                preparedStatement1.setInt(1, id);
                preparedStatement1.setLong(2, books.getId());
                preparedStatement1.execute();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from orders where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            PreparedStatement preparedStatement1 = connection.prepareStatement("delete from order_books where id_order = ?");
            preparedStatement1.setLong(1, id);
            preparedStatement1.execute();
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
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from orders");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int positions = resultSet.getInt(2);
                Long id_user = resultSet.getLong(3);
                User user = userDaoDB.getById(id_user);
                OrderStatus orderStatus = OrderStatus.valueOf(resultSet.getString(4));
                List<Book> book = new ArrayList<>();
                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1.executeQuery("select * from order_books where order_id = id");
                while (resultSet1.next()) {
                    long id_book = resultSet1.getLong(3);
                    Book book1 = bookDaoDB.getById(id_book);
                    book.add(book1);
                }
                Order order = new Order(id, positions, book, user, orderStatus);
                orders.add(order);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order getById(int id) {
        Order order = new Order();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int positions = resultSet.getInt(2);
            User user = userDaoDB.getById(resultSet.getLong(3));
            OrderStatus orderStatus = OrderStatus.valueOf(resultSet.getString(4));
            List<Book> book = new ArrayList<>();
            Statement statement1 = connection.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("select * from order_books where id_order = id");
            while (resultSet1.next()) {
                long id_book = resultSet1.getLong(2);
                Book book1 = bookDaoDB.getById(id_book);
                book.add(book1);
            }
            order.setId(id);
            order.setOrderStatus(orderStatus);
            order.setPositions(positions);
            order.setUser(user);
            order.setBook(book);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


    @Override
    public List<Order> getByUser(User user) {
        long id = user.getId();
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select from orders where id_user  = id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_order = resultSet.getInt(1);
                int positions = resultSet.getInt(2);
                OrderStatus orderStatus = OrderStatus.valueOf(resultSet.getString(4));
                List<Book> book = new ArrayList<>();
                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1.executeQuery("select * from order_books where id_order = id_order");
                while (resultSet1.next()) {
                    long id_book = resultSet1.getLong(2);
                    Book book1 = bookDaoDB.getById(id_book);
                    book.add(book1);
                }
                Order order = new Order(id_order, positions, book, user, orderStatus);
                orders.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return orders;
    }

    @Override
    public List<Order> getByBook(Book book) {
        long id = book.getId();
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select from order_books where id_book  = id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_order = resultSet.getInt(1);
                Order order = new OrderDaoDB().getById(id_order);
                orders.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> getByOrderStatus(OrderStatus orderStatus) {
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select from orders where orderStatus  = orderstatus");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_order = resultSet.getInt(1);
                Order order = new OrderDaoDB().getById(id_order);
                orders.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean contains(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id from orders");
            while (resultSet.next()) {
                if (resultSet.getLong(1) == id) {
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
