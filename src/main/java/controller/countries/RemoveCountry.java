package controller.countries;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BaseController;

/**
 * Servlet implementation class RemoveCountry
 */
@WebServlet("/RemoveCountry")
public class RemoveCountry extends BaseController {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!verifyUserLoggedIn(request, response)) return;
		if (!isAdmin(request)) {
			response.sendError(403, "Unauthorized");
			return;
		}
		int countryId = Integer.parseInt(request.getParameter("id"));
		countriesDao.deleteById(countryId);

		response.sendRedirect("CountryList");
	}

	@Override
	protected String getPageTitle() {
		return "Land löschen";
	}

}
