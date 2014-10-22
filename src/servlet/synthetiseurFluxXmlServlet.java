package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FormatManager;

@WebServlet("/synthetiseurFluxXml")
public class synthetiseurFluxXmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public synthetiseurFluxXmlServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String xml = FormatManager.getXML();
		out.println(xml);
	}
}
