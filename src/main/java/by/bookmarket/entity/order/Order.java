package by.bookmarket.entity.order;

import by.bookmarket.entity.book.Book;
import by.bookmarket.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private int positions;
    private List<Book> book;
    private User user;
    private OrderStatus orderStatus;

    public Order(int positions, List<Book> book, User user, OrderStatus orderStatus) {
        this.positions = positions;
        this.book = book;
        this.user = user;
        this.orderStatus = orderStatus;
    }
}
