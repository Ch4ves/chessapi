package br.com.chessapi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.chessapi.model.Player;

public class PlayerDto {

	private long id;

	private int fideId;

	private String name;

	private String country;

	private int rating;

	private int yearOfBirth;

	public PlayerDto(Player player) {

		this.id = player.getId();
		this.fideId = player.getFideId();
		this.name = player.getName();
		this.country = player.getCountry();
		this.rating = player.getRating();
		this.yearOfBirth = player.getYearOfBirth();
	}

	public static List<PlayerDto> convert(List<Player> players) {

		return players.stream().map(PlayerDto::new).collect(Collectors.toList());

	}

	public long getId() {
		return id;
	}

	public int getFideId() {
		return fideId;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public int getRating() {
		return rating;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

}
