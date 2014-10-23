package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FormatManager;

@WebServlet("/synthetiseurFlux")
public class SynthetiseurFluxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SynthetiseurFluxServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int nbFlux = 0;
		String format = "xml";
		String result = "";
		Boolean isNbFlux = false;
		PrintWriter out = response.getWriter();

		if (request.getParameter("nbFlux") != null) {
			try {
				nbFlux = Integer.parseInt(request.getParameter("nbFlux"));
				isNbFlux = true;
			} catch (NumberFormatException e) {

			}
		}

		if (request.getParameter("format") != null) {
			format = request.getParameter("format");
		}

		response.setCharacterEncoding("UTF-8");

		switch (format) {
		case "xml":
			response.setContentType("text/xml");
			result = FormatManager.getXML(nbFlux, isNbFlux);
			break;

		case "html":
			response.setContentType("text/html");
			result = FormatManager.getHTML(nbFlux, isNbFlux);
			break;

		case "json":
			response.setContentType("text/json");
			result = FormatManager.getJson(nbFlux, isNbFlux);
			break;

		default:
			break;
		}

		out.println(result);

	}
}
