package model;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class FormatManager {

	public static String getXML(int nbFlux, Boolean isNbFlux) {
		ReadXMLFile reader = new ReadXMLFile();
		reader.parseRss();

		List<Article> newsSynthese = new ArrayList<Article>();
		newsSynthese = reader.getNewsSynthese();

		List<Article> newsSyntheseCut = new ArrayList<Article>();

		if (nbFlux < newsSynthese.size() && isNbFlux) {
			for (int i = 0; i < nbFlux; i++) {
				newsSyntheseCut.add(newsSynthese.get(i));
			}
		} else {
			newsSyntheseCut = newsSynthese;
		}

		XStream xstream = new XStream(new StaxDriver());
		String xml = xstream.toXML(newsSyntheseCut);
		return xml;
	}

	public static String getJson(int nbFlux, Boolean isNbFlux) {
		ReadXMLFile reader = new ReadXMLFile();

		reader.parseRss();

		List<Article> newsSynthese = new ArrayList<Article>();
		List<Article> newsSyntheseCut = new ArrayList<Article>();
		
		newsSynthese = reader.getNewsSynthese();

		if (nbFlux < newsSynthese.size() && isNbFlux) {
			for (int i = 0; i < nbFlux; i++) {
				newsSyntheseCut.add(newsSynthese.get(i));
			}
		} else {
			newsSyntheseCut = newsSynthese;
		}
		
		Gson gson = new GsonBuilder().create();
		String resJson = gson.toJson(newsSyntheseCut);
		return (resJson);
	}

	public static String getHTML(int nbFlux, Boolean isNbFlux) {
		String html = "";
		try {
			Writer wr = new StringWriter();

			String xml = FormatManager.getXML(nbFlux, isNbFlux);
			TransformerFactory tFactory = TransformerFactory.newInstance();

			Transformer transformer = tFactory
					.newTransformer(new javax.xml.transform.stream.StreamSource(
							"D:/workspace/Eclipse/accuponcteur/WebContent/WEB-INF/flux.xsl"));

			transformer.transform(new javax.xml.transform.stream.StreamSource(
					new StringReader(xml)),
					new javax.xml.transform.stream.StreamResult(wr));
			html = wr.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}
}
