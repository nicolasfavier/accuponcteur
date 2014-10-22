package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFile {

	private List<Article> newsSynthese = new ArrayList<Article>();
	private Article tempArticle;

	public List<Article> getNewsSynthese() {
		return newsSynthese;
	}

	public void parseRss() {

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean bitem = false;
				boolean btitle = false;
				boolean bdesc = false;
				boolean bdate = false;
				boolean bcreator = false;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {

					if (qName.equalsIgnoreCase("ITEM")) {
						bitem = true;
						tempArticle = new Article();
					}
					
					if (qName.equalsIgnoreCase("TITLE")) {
						btitle = true;
					}

					if (qName.equalsIgnoreCase("DESCRIPTION")) {
						bdesc = true;
					}

					if (qName.equalsIgnoreCase("DC:DATE")) {
						bdate = true;
					}

					if (qName.equalsIgnoreCase("DC:CREATOR")) {
						bcreator = true;
					}

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {

					if (qName.equalsIgnoreCase("ITEM")) {
						newsSynthese.add(tempArticle);
						bitem = false;
					}
										
				}

				public void characters(char ch[], int start, int length)
						throws SAXException {
					
					if (btitle && bitem) {
						tempArticle = new Article();
						tempArticle.setTitre(new String(ch, start, length));
						btitle = false;
					}

					if (bdesc && bitem) {
						tempArticle.setDescription(new String(ch, start, length));
						bdesc = false;
					}

					if (bdate && bitem) {
						tempArticle.setDate(new String(ch, start, length));
						bdate = false;
					}

					if (bcreator && bitem) {
						tempArticle.setCreateur(new String(ch, start, length));
						bcreator = false;
					}

				}

			};

			saxParser.parse("http://www.lemondeinformatique.fr/flux-rss/thematique/toutes-les-actualites/rss.xml", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}