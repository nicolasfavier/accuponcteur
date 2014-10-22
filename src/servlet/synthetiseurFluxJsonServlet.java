package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FormatManager;

@WebServlet("/synthetiseurFluxJson")
public class synthetiseurFluxJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public synthetiseurFluxJsonServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String json = FormatManager.getJson();
		out.println(json);

	}
}
