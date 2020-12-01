package by.bookmarket.web.servlet;

import by.bookmarket.entity.user.Role;
import by.bookmarket.entity.user.User;
import by.bookmarket.service.UserService;
import by.bookmarket.validator.RegistrationValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg", name = "regServlet")
public class RegistrationServlet extends HttpServlet {
    private UserService userService = new UserService();
    private RegistrationValidator registrationValidator = new RegistrationValidator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/menu/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        if (registrationValidator.validLogin(username)){
            if (userService.contains(username)){
                req.setAttribute("userExistError", "Error: User with this login already exist!");
                getServletContext().getRequestDispatcher("/pages/menu/registration.jsp").forward(req, resp);
            }
            if (registrationValidator.validPassword(password)){
                if (registrationValidator.validName(name)){
                    User user = new User(username, password, name, Role.USER);
                    userService.synchronizedSave(user);
                    getServletContext().getRequestDispatcher("/pages/menu/authorization.jsp").forward(req, resp);
                }else{
                    req.setAttribute("nameError", "Error: name must be at least 2 symbols!");
                    getServletContext().getRequestDispatcher("/pages/menu/registration.jsp").forward(req, resp);
                }
            }else{
                req.setAttribute("passwordError", "Error: password must be at least 5 symbols!");
                getServletContext().getRequestDispatcher("/pages/menu/registration.jsp").forward(req, resp);
            }
        }else{
            req.setAttribute("usernameError", "Error: login must be at least 3 symbols!");
            getServletContext().getRequestDispatcher("/pages/menu/registration.jsp").forward(req, resp);
        }

    }
}