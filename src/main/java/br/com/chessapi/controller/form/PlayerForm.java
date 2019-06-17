package br.com.chessapi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.chessapi.model.Player;

public class PlayerForm {

	@NotNull
	private int fideId;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String country;
	@NotNull
	private int rating;
	@NotNull
	private int yearOfBirth;

	public int getFideId() {
		return fideId;
	}

	public void setFideId(int fideId) {
		this.fideId = fideId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public Player convert() {
		return new Player(this.fideId, this.name, this.country, this.rating, this.yearOfBirth);
	}

}
