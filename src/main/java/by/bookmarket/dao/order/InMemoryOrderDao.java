package by.bookmarket.dao.order;

import by.bookmarket.entity.book.Book;
import by.bookmarket.entity.order.Order;
import by.bookmarket.entity.order.OrderStatus;
import by.bookmarket.entity.user.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderDao implements OrderDao {
    private List<Order> orders = new ArrayList<>();

    public boolean save(List<Order> ordersAll) {
        return this.orders.addAll(ordersAll);
    }

    @Override
    public boolean save(Order order) {
        return orders.add(order);
    }

    @Override
    public boolean deleteById(int id) {
        orders.remove(id);
        return true;
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public Order getById(int id) {
        for (Order orderById : orders) {
            if (orderById.getId() == id) {
                return orderById;
            }
        }
        return null;
    }

    @Override
    public List<Order> getByUser(User user) {
        List<Order> ordersByUser = new ArrayList<>();
        for (Order orderByUser : orders) {
            if (orderByUser.getUser().equals(user)) {
                ordersByUser.add(orderByUser);
            }
            return ordersByUser;
        }
        return null;
    }

    @Override
    public List<Order> getByBook(Book book) {
        List<Order> ordersByBook = new ArrayList<>();
        for (Order orderByBook : orders) {
            if (orderByBook.getBook().equals(book)) {
                ordersByBook.add(orderByBook);
            }
            return ordersByBook;
        }
        return null;
    }

    @Override
    public List<Order> getByOrderStatus(OrderStatus orderStatus) {
        List<Order> ordersByStatus = new ArrayList<>();
        for (Order orderByStatus : ordersByStatus) {
            if (orderByStatus.getOrderStatus().equals(orderStatus)) {
                ordersByStatus.add(orderByStatus);
            }
            return ordersByStatus;
        }
        return null;
    }

    @Override
    public boolean contains(int id) {
        for (Order orderById : orders) {
            if (orderById.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
