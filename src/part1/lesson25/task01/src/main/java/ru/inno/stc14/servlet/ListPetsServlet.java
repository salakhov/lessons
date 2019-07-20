package ru.inno.stc14.servlet;

import ru.inno.stc14.entity.Pet;
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
        name="petList",
        urlPatterns = "/pet/list"
)
public class ListPetsServlet extends HttpServlet {
    private AnimalService animal;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        animal = new AnimalServiceImpl(connection);
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pet> res = animal.getPetList();
        req.setAttribute("pets", res);
        req.setAttribute("PageTitle", "Pets");
        req.setAttribute("PageBody", "pets.jsp");
        req.getRequestDispatcher("/layout.jsp")
                .forward(req, resp);
    }
}
