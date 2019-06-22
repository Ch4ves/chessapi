package br.com.chessapi.util;

import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


//Class de teste, use o PlayerHandler para importar o xml caso necessario.

public class Sax {

	public static void main(String[] args) throws Exception {

		@SuppressWarnings("deprecation")
		XMLReader reader = XMLReaderFactory.createXMLReader();
		PlayerHandler ph = new PlayerHandler();
		reader.setContentHandler(ph);

		// https://ratings.fide.com/download.phtml
		// Wont download the xml and add to the project bcz the filesize is too large
		// for github repo.
		// More then 33k players and almost 100mb
		InputStream is = new FileInputStream("");

		reader.parse(new InputSource(is));
		System.out.println(ph.getPlayers().size());

	}
}
