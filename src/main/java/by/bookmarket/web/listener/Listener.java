package by.bookmarket.web.listener;

import by.bookmarket.service.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener
public class Listener implements HttpSessionListener, HttpSessionAttributeListener, ServletContextListener {
    private UserService userService = new UserService();



    @Override
    public void contextInitialized(ServletContextEvent sce) {
        userService.synchronize();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }


}
