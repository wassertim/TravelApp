package controller.countries;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BaseController;
import model.Country;

/**
 * Servlet implementation class NewCountry
 */
@WebServlet("/NewCountry")
public class NewCountry extends BaseController {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!verifyUserLoggedIn(request, response)) return;
		if (!isAdmin(request)) {
			response.sendError(403, "Unauthorized");
			return;
		}
		super.doGet(request, response);

		request.getRequestDispatcher("countries/new.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!isAdmin(request)) {
			response.sendError(403, "Unauthorized");
			return;
		}
		String title = request.getParameter("title");
		Country newCountry = new Country(0, title);
		countriesDao.add(newCountry);

		response.sendRedirect("CountryList");
	}

	@Override
	protected String getPageTitle() {
		return "Neues Land erfassen";
	}
}
