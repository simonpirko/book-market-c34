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

@WebServlet(urlPatterns = "/pro", name = "proServlet")
public class ProfileServlet extends HttpServlet {
    private UserService userService = new UserService();
    private RegistrationValidator registrationValidator = new RegistrationValidator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("regVisibility",false);
        req.setAttribute("authVisibility",false);
        req.setAttribute("profileMenuVisibility",true);
        getServletContext().getRequestDispatcher("/pages/menu/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String edit = req.getParameter("edit");

        if(edit!=null){
            String newPassword = req.getParameter("password");
            String newName=req.getParameter("name");
            if (registrationValidator.validPassword(newPassword) && registrationValidator.validName(newName)){
                long id=user.getId();
                userService.synchronizedUpdateName(newName,id);
                userService.synchronizedUpdatePassword(newPassword,id);
                req.setAttribute("messageEdit", "Изменения сохранены");
                session.setAttribute("user",user);
                doGet(req,resp);
            }
            req.setAttribute("messageEdit","Error: Check your new name or password. Password must be at least 4 symbols! Name must be at least 2 symbols");
        }
        doGet(req,resp);
    }
}
