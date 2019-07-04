package ru.inno.stc14.servlet;

import ru.inno.stc14.service.PersonService;
import ru.inno.stc14.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Сервлет авторизации. Добавлен в рамках выполенния ДЗ
 */
@WebServlet(
        name = "auth",
        urlPatterns = {"/auth" }
)
public class AuthServlet extends HttpServlet {
    private PersonService person;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        person = new PersonServiceImpl(connection);
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("user");
        String password = req.getParameter("password");

        System.out.println(name);
        System.out.println(password);
        if(person==null)
            System.out.println("Initialisation person failed");
        if(person.checkPerson(name,password)){
          resp.sendRedirect(req.getContextPath()+"/main.jsp");
        }
        else
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
    }
}
