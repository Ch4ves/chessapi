package br.com.chessapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.chessapi.controller.dto.PlayerDto;
import br.com.chessapi.controller.form.PlayerForm;
import br.com.chessapi.model.Player;
import br.com.chessapi.repository.PlayerRepository;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;

	@GetMapping
	public List<PlayerDto> list(String name) {

		if (name == null) {
			List<Player> players = playerRepository.findAll();
			return PlayerDto.convert(players);

		} else {

			List<Player> player = playerRepository.findByName(name);
			return PlayerDto.convert(player);

		}

	}
	
	@PostMapping
	public ResponseEntity<PlayerDto> save(@RequestBody @Valid PlayerForm form, UriComponentsBuilder uriBuilder){
		
		Player player = form.convert();
		playerRepository.save(player);
		URI uri = uriBuilder.path("/players/{id}").buildAndExpand(player.getId()).toUri();
		return ResponseEntity.created(uri).body(new PlayerDto(player));
		
	}
	

}
