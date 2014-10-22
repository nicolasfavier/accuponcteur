package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class FormatManager {

	public static String getXML(){
		ReadXMLFile reader = new ReadXMLFile();
		reader.parseRss();
		
		List<Article> newsSynthese = new ArrayList<Article>();
		newsSynthese = reader.getNewsSynthese();

		XStream xstream = new XStream(new StaxDriver());
		String xml = xstream.toXML(newsSynthese);
		return xml;
	}

	public static String getJson(){
		ReadXMLFile reader = new ReadXMLFile();

		reader.parseRss();
		
		List<Article> newsSynthese = new ArrayList<Article>();
		newsSynthese = reader.getNewsSynthese();

		Gson gson = new GsonBuilder().create();
		String resJson = gson.toJson(newsSynthese);
		return(resJson);
	}
}
