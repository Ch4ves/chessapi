package br.com.chessapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.chessapi.controller.dto.PlayerDto;
import br.com.chessapi.controller.form.PlayerForm;
import br.com.chessapi.controller.form.UpdatePlayerForm;
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
	@Transactional
	public ResponseEntity<PlayerDto> save(@RequestBody @Valid PlayerForm form, UriComponentsBuilder uriBuilder) {

		Player player = form.convert();
		playerRepository.save(player);
		URI uri = uriBuilder.path("/players/{id}").buildAndExpand(player.getId()).toUri();
		return ResponseEntity.created(uri).body(new PlayerDto(player));

	}

	@GetMapping("/{id}")
	public ResponseEntity<PlayerDto> detail(@PathVariable Long id) {

		Optional<Player> player = playerRepository.findById(id);
		if (player.isPresent()) {

			return ResponseEntity.ok(new PlayerDto(player.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PlayerDto> update(@PathVariable Long id, @RequestBody @Valid UpdatePlayerForm form,
			UriComponentsBuilder uriBuilder) {

		Optional<Player> optional = playerRepository.findById(id);
		if (optional.isPresent()) {
			Player player = form.update(id, playerRepository);
			return ResponseEntity.ok(new PlayerDto(player));
		}

		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {

		Optional<Player> optional = playerRepository.findById(id);
		if (optional.isPresent()) {
			playerRepository.deleteById(id);

		}

		return ResponseEntity.notFound().build();

	}


}
