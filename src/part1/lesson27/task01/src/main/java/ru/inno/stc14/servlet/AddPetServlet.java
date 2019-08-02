package ru.inno.stc14.servlet;

import ru.inno.stc14.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Сервлет обрабатывает запросы по работе с объектами класса Pet
 */
@WebServlet(
        name = "pet",
        urlPatterns = {"/pet" })
//@Override()
public class AddPetServlet extends HttpServlet {
    private Home home;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        home = new HomeImpl(connection);
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("PageTitle", "New pet");
        req.setAttribute("PageBody", "form_pet.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String master = req.getParameter("master");
        String type = req.getParameter("type");

        home.add(new Pet(name,master,type));
        resp.sendRedirect(req.getContextPath() + "/pet/list");
    }
}
