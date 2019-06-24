package br.com.chessapi.controller.dto;

import org.springframework.data.domain.Page;

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

	public static Page<PlayerDto> convert(Page<Player> players) {

		return players.map(PlayerDto::new);
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
