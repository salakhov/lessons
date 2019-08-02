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
 * Сервлет обрабатывает запросы по работе с объектами класса Person
 */

@WebServlet(
        name = "person",
        urlPatterns = {"/person" })
public class AddPersonServlet extends HttpServlet {

    private Home home;
    private Jkx jkx1,jkx2,jkx3;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        home = new HomeImpl(connection);
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("PageTitle", "New Student");
        req.setAttribute("PageBody", "form.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String birth = req.getParameter("birth");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");


        home.add(new Person(name, birth,email,phone));
        resp.sendRedirect(req.getContextPath() + "/person/list");
    }
}
