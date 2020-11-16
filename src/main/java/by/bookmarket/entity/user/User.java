package by.bookmarket.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private static int incId = 1;
    private long id = incId++;
    private String login;
    private String password;
    private String name;
    private Role role;
}
