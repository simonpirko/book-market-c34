package by.bookmarket.web.servlet;

import by.bookmarket.entity.user.User;
import by.bookmarket.service.UserService;
import by.bookmarket.validator.RegistrationValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth", name = "authServlet")
public class AuthorizationServlet extends HttpServlet {
    private UserService userService = new UserService();
    private RegistrationValidator registrationValidator = new RegistrationValidator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/menu/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        if (userService.contains(login)){
            String password = req.getParameter("password");
            User user = userService.getByUsernameFromInMemory(login);
            if (user.getPassword().equals(password)){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/pages/menu/index.jsp").forward(req, resp);
            }else {
                req.setAttribute("wrongPassword", "Error: wrong password!");
                getServletContext().getRequestDispatcher("/pages/menu/authorization.jsp").forward(req, resp);
            }
        }else {
            req.setAttribute("userDoesntExist", "Error: no such user!");
            getServletContext().getRequestDispatcher("/pages/menu/authorization.jsp").forward(req, resp);
        }
    }
}
