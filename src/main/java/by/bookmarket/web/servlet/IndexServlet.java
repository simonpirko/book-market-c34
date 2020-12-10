package by.bookmarket.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/", name = "index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            req.setAttribute("regVisibility", true);
            req.setAttribute("authVisibility", true);
            req.setAttribute("profileMenuVisibility", false);
            getServletContext().getRequestDispatcher("/pages/menu/index.jsp").forward(req, resp);
        } else {
            req.setAttribute("regVisibility",false);
            req.setAttribute("authVisibility",false);
            req.setAttribute("profileMenuVisibility",true);
            getServletContext().getRequestDispatcher("/pages/menu/index.jsp").forward(req, resp);
        }
    }
}
