package by.bookmarket.web.servlet;

import by.bookmarket.entity.user.Role;
import by.bookmarket.entity.user.User;
import by.bookmarket.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/pro", name = "proServlet")
public class ProfileServlet extends HttpServlet {
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Role role = (Role) session.getAttribute("role");
        String login = (String) session.getAttribute("login");
        String edit = req.getParameter("edit");
        if(role==Role.USER && edit!=null){
            String newLogin = req.getParameter("login");
            String newPassword = req.getParameter("password");
            String newName=req.getParameter("name");
            User user = userService.getByUsernameFromInMemory(login);
            user.setUsername(newLogin);
            user.setPassword(newPassword);
            user.setName(newName);
            req.setAttribute("messageEdit", "Изменения сохранены");
        }
        getServletContext().getRequestDispatcher("/pages/menu/profile.jsp").forward(req, resp);
    }
}
