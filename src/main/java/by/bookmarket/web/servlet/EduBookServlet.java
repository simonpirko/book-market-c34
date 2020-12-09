package by.bookmarket.web.servlet;

import by.bookmarket.entity.book.Book;
import by.bookmarket.entity.book.BookStatus;
import by.bookmarket.entity.book.Format;
import by.bookmarket.entity.book.Genre;
import by.bookmarket.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/eduBook", name = "eduBookServlet")
public class EduBookServlet extends HttpServlet {
    private BookService bookService = new BookService();
    private int count=0;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if(count==0) {
            Book bookFirst = new Book("Изучаем Java", "Берт Бейтс, Кэти Сьерра", Format.HARDBACK, "Москва: Эксмо", 2015, 720, Genre.EDUCATION, 33.47, BookStatus.AVAILABLE, "Это не просто книга. Она не только научит вас теории языка Java и объектно-ориентированного программирования, она сделает вас программистом.");
           // httpSession.setAttribute("eduBook", bookFirst);
            bookService.synchronizedSaveFirst(bookFirst);

            List<Book> all = bookService.getAllFromInMemory();
            List<Book> allEducation= new ArrayList<>();
            for(Book book: all){
                if(book.getGenre().equals("EDUCATION")){
                    allEducation.add(book);
                }
            }
            httpSession.setAttribute("allNew", all);
            httpSession.setAttribute("allEducation", allEducation);
            count++;
        }

        getServletContext().getRequestDispatcher("/pages/categories/education.jsp").forward(req, resp);
    }
}
