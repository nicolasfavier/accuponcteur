package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FormatManager;

@WebServlet("/synthetiseurFluxHtml")
public class SynthetiseurFluxHtmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SynthetiseurFluxHtmlServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String html = FormatManager.getHTML();
		out.println(html);
		
//		String xml = FormatManager.getXML();
//		TransformerFactory tFactory = TransformerFactory.newInstance();
//
//		Transformer transformer;
//		try {
//			transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource("D:/workspace/Eclipse/accuponcteur/WebContent/WEB-INF/flux.xsl"));
//			transformer.transform(	new javax.xml.transform.stream.StreamSource(new StringReader(xml)),
//					new javax.xml.transform.stream.StreamResult(out));
//		
//		
//		} catch (TransformerConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (TransformerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		 
	
	}
}
