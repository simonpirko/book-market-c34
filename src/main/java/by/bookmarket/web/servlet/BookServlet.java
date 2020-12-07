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

@WebServlet(urlPatterns = "/book", name = "bookServlet")
public class BookServlet extends HttpServlet {
    private BookService bookService = new BookService();
    private int count=0;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if(count==0) {
            Book bookFirst = new Book("1984", "Джордж Оруэлл", Format.HARDBACK, "Москва: Издательство АСТ", 2020, 318, Genre.ROMANCE, 16.29, BookStatus.AVAILABLE, "По Оруэллу, нет и не может быть ничего ужаснее тотальной несвободы...");
          //  httpSession.setAttribute("book", bookFirst);
            bookService.synchronizedSaveFirst(bookFirst);
            List<Book> all = bookService.getAllFromInMemory();
            List<Book> allRomance= new ArrayList<>();
            for(Book book: all){
                if(book.getGenre().equals("ROMANCE")){
                    allRomance.add(book);
                }
            }
            httpSession.setAttribute("all", all);
            httpSession.setAttribute("allRomance", allRomance);
            count++;
        }

        getServletContext().getRequestDispatcher("/pages/categories/fiction.jsp").forward(req, resp);
    }
}
