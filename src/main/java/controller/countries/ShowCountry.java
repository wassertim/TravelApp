package controller.countries;

import controller.BaseController;
import model.Country;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KategorieAnzeigen
 */
@WebServlet("/ShowCountry")
public class ShowCountry extends BaseController {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!verifyUserLoggedIn(request, response)) return;
		if (!isAdmin(request)) {
			response.sendError(403, "Unauthorized");
			return;
		}
		super.doGet(request, response);

		int id = Integer.parseInt(request.getParameter("id"));
		Country country = countriesDao.getById(id);
		request.setAttribute("country", country);

		request.getRequestDispatcher("countries/show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		if (!verifyUserLoggedIn(request, response)) return;
		if (!isAdmin(request)) {
			response.sendError(403, "Unauthorized");
			return;
		}
		super.doGet(request, response);

		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		countriesDao.update(id, title);

		response.sendRedirect("CountryList");
	}

	@Override
	protected String getPageTitle() {
		// TODO Auto-generated method stub
		return "Land anzeigen";
	}

}
