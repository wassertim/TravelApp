package controller.travel.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BaseController;

/**
 * Servlet implementation class RemoveCountry
 */
@WebServlet("/RemoveTravelDestination")
public class RemoveTravelDestination extends BaseController {
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

		int id = Integer.parseInt(request.getParameter("id"));
		travelDestinationDao.deleteById(id);

		response.sendRedirect("TravelDestinationsAdmin");
	}

	@Override
	protected String getPageTitle() {
		return "Land bereist löschen";
	}

}
