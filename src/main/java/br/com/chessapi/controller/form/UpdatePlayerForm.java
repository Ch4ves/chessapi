package br.com.chessapi.controller.form;

import javax.validation.constraints.NotNull;

import br.com.chessapi.model.Player;
import br.com.chessapi.repository.PlayerRepository;

public class UpdatePlayerForm {

	@NotNull
	private int rating;

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Player update(Long id, PlayerRepository playerRepository) {
		Player player = playerRepository.getOne(id);
		player.setRating(this.rating);

		return player;
	}

}
