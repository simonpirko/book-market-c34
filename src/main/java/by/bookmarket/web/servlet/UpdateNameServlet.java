package by.bookmarket.web.servlet;

import by.bookmarket.entity.user.User;
import by.bookmarket.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateNameServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            User user = (User) req.getSession().getAttribute("user");
            resp.getWriter().println(user);
        } else {
            resp.getWriter().println("User is not auth");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp, String newName, String id) throws ServletException, IOException {
        id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        userService.synchronizedUpdateName(newName, Long.parseLong(id));
    }
}
