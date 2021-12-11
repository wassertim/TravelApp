package controller.travel.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BaseController;
import model.Country;
import model.Parameter;
import model.TravelDestination;
import viewmodel.CountryViewModel;

@WebServlet("/TravelDestinationsAdmin")
public class TravelDestinationsAdmin extends BaseController {
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
        if (!isAdmin(request)) {
            response.sendError(403, "Unauthorized");
            return;
        }

        super.doGet(request, response);
        ArrayList<TravelDestination> travelDestinations = travelDestinationDao.getAll();

        request.setAttribute("travelDestinations", travelDestinations);
        request.getRequestDispatcher("travel-destinations/admin/list.jsp").forward(request, response);
    }

    @Override
    protected String getPageTitle() {
        return "Länder der Users schon bereits bereist haben";
    }
}
