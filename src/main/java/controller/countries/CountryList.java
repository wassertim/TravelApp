package controller.countries;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BaseController;
import model.Country;

@WebServlet("/CountryList")
public class CountryList extends BaseController {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        if (!verifyUserLoggedIn(request, response)) {
            return;
        }
        super.doGet(request, response);

        request.setAttribute("countries", countriesDao.getAll());
        request.getRequestDispatcher("countries/list.jsp").forward(request, response);
    }

    @Override
    protected String getPageTitle() {
        return "Alle Länder";
    }
}
