package ru.inno.stc14.servlet;

import ru.inno.stc14.entity.Person;
import ru.inno.stc14.service.AnimalService;
import ru.inno.stc14.service.AnimalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(
        name="personList",
        urlPatterns = "/person/list"
)
public class ListPersonServlet extends HttpServlet {
    private AnimalService animal;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        animal = new AnimalServiceImpl(connection);
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> res = animal.getPersonList();
        req.setAttribute("persons", res);
        req.setAttribute("PageTitle", "Students");
        req.setAttribute("PageBody", "persons.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }
}
