package controller.travel;

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

@WebServlet("/TravelDestinations")
public class TravelDestinations extends BaseController {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        if(!verifyUserLoggedIn(request, response)) return;
        super.doGet(request, response);
        String userName = getUsername(request);
        ArrayList<CountryViewModel> countries = getCountryViewModel(userName);

        request.setAttribute("countries", countries);
        request.getRequestDispatcher("travel-destinations/form.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        if(!verifyUserLoggedIn(request, response)) return;
        super.doGet(request, response);
        String[] countryIds = request.getParameterValues("countryId");
        if (countryIds == null) {
            request.getRequestDispatcher("travel-destinations/failure.jsp").forward(request, response);
        }
        String userName = getUsername(request);
        travelDestinationDao.addVisitedCountries(userName, countryIds);
        ArrayList<CountryViewModel> countries = getCountryViewModel(userName);

        request.setAttribute("countries", countries);
        request.getRequestDispatcher("travel-destinations/success.jsp").forward(request, response);
    }

    private ArrayList<CountryViewModel> getCountryViewModel(String userName) {
        ArrayList<Country> allCountries = countriesDao.getAll();
        Parameter userNameParam = new Parameter("benutzer", userName);
        ArrayList<TravelDestination> travelDestinations = travelDestinationDao.getAll(userNameParam);
        return getCountriesViewModel(allCountries, travelDestinations);
    }

    private ArrayList<CountryViewModel> getCountriesViewModel(ArrayList<Country> allCountries,
        ArrayList<TravelDestination> travelDestinations) {
        ArrayList<CountryViewModel> result = new ArrayList<>();
        for (Country country : allCountries) {
            boolean traveled = isTraveled(country.getId(), travelDestinations);
            result.add(new CountryViewModel(country, traveled));
        }
        return result;
    }

    private boolean isTraveled(int countryId, ArrayList<TravelDestination> travelDestinations) {
        for (TravelDestination travelDestination : travelDestinations) {
            if (travelDestination.getCountryId() == countryId) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected String getPageTitle() {
        return "Länder die du bereits bereist hast";
    }
}
