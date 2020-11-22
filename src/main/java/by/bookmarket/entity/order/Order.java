package by.bookmarket.entity.order;

import by.bookmarket.entity.book.Book;
import by.bookmarket.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private long id;
    private int positions;
    private Book book;
    private User user;
    private OrderStatus orderStatus;
}
