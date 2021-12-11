package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CountriesDao;
import dao.TravelDestinationDao;

public abstract class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected CountriesDao countriesDao = new CountriesDao();
	protected TravelDestinationDao travelDestinationDao = new TravelDestinationDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setPageTitle(request);
	}

	protected void setPageTitle(HttpServletRequest request) {
		request.setAttribute("pageTitle", getPageTitle());
	}

	protected String getUsername(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("loggedInUsername");
		if (username == null || username.equals("")) {
			return null;
		} else {
			return username;
		}
	}

	protected boolean isAdmin(HttpServletRequest request) {
		String username = getUsername(request);
		return username != null && username.toLowerCase().equals("admin");
	}

	protected boolean verifyUserLoggedIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = getUsername(request);
		if (username == null) {
			response.sendRedirect("LoginUser");
			return false;
		}

		return true;
	}

	protected abstract String getPageTitle();
}
