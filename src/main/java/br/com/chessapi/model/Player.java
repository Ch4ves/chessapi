package br.com.chessapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

	public Player() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int fideId;

	private String name;

	private String country;

	private int rating;

	private int yearOfBirth;

	public Player(int fideId, String name, String country, int rating, int yearOfBirth) {
		super();
		this.fideId = fideId;
		this.name = name;
		this.country = country;
		this.rating = rating;
		this.yearOfBirth = yearOfBirth;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

}
