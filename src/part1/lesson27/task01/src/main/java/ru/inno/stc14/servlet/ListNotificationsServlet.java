package ru.inno.stc14.servlet;

import ru.inno.stc14.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;


/**
 * Класс сервлет для отображения списка уведомлений ЖКХ
 */

@WebServlet(
        name="messages",
        urlPatterns = "/messages"
)
public class ListNotificationsServlet extends HttpServlet {
    private Home home;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        home = new HomeImpl(connection);
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> res = home.getNotifications();
        req.setAttribute("messages", res);
        req.setAttribute("PageTitle", "Messages");
        req.setAttribute("PageBody", "notifications.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }
}
