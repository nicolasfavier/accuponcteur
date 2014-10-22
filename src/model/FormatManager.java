package model;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class FormatManager {

	public static String getXML() {
		ReadXMLFile reader = new ReadXMLFile();
		reader.parseRss();

		List<Article> newsSynthese = new ArrayList<Article>();
		newsSynthese = reader.getNewsSynthese();

		XStream xstream = new XStream(new StaxDriver());
		String xml = xstream.toXML(newsSynthese);
		return xml;
	}

	public static String getJson() {
		ReadXMLFile reader = new ReadXMLFile();

		reader.parseRss();

		List<Article> newsSynthese = new ArrayList<Article>();
		newsSynthese = reader.getNewsSynthese();

		Gson gson = new GsonBuilder().create();
		String resJson = gson.toJson(newsSynthese);
		return (resJson);
	}

	public static String getHTML() {
		String html = "";
		try {
			Writer wr= new StringWriter();
			
			String xml = FormatManager.getXML();
			TransformerFactory tFactory = TransformerFactory.newInstance();

			Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource("D:/workspace/Eclipse/accuponcteur/WebContent/WEB-INF/flux.xsl"));

			 transformer.transform(	new javax.xml.transform.stream.StreamSource(new StringReader(xml)),
									new javax.xml.transform.stream.StreamResult(wr));
			 html = wr.toString();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return html;
	}
}
