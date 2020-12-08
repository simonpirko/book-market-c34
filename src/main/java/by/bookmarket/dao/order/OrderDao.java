package by.bookmarket.dao.order;

import by.bookmarket.entity.book.Book;
import by.bookmarket.entity.order.Order;
import by.bookmarket.entity.order.OrderStatus;
import by.bookmarket.entity.user.User;

import java.util.List;

public interface OrderDao {
    boolean save(Order order);

    boolean deleteById(int id);

    List<Order> getAll();

    Order getById(int id);

    List<Order> getByUser(User user);

    List<Order> getByBook(Book book);

    List<Order> getByOrderStatus(OrderStatus orderStatus);

    boolean contains(int id);
}
