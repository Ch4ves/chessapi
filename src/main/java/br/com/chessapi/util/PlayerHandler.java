package br.com.chessapi.util;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.chessapi.model.Player;

public class PlayerHandler extends DefaultHandler {

	private List<Player> players = new ArrayList<Player>();
	private Player player;
	private StringBuilder content = new StringBuilder();

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if ("player".equals(qName)) {
			player = new Player();
		}

		content = new StringBuilder();

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		content.append(new String(ch, start, length));
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// System.out.println(qName);
		if ("player".equals(qName)) {
			players.add(player);
		} else if ("name".equals(qName)) {
			player.setName(content.toString());
		} else if ("fideid".equals(qName)) {
			player.setFideId(Integer.parseInt(content.toString()));
		} else if ("country".equals(qName)) {
			player.setCountry(content.toString());
		} else if ("rating".equals(qName)) {
			player.setRating(Integer.parseInt(content.toString()));
		} else if ("birthday".equals(qName)) {
			if(content.toString().equals(null))player.setYearOfBirth(0);
			if(player.getYearOfBirth() != 0) {
				player.setYearOfBirth(Integer.parseInt(content.toString()));

			}
			
		}

	}

	public List<Player> getPlayers() {
		return players;
	}

}
