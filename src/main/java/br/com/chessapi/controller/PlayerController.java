package br.com.chessapi.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	
	//Just testing cache. Not saying that's a good a ideia to use in this specific case.
	@Cacheable(value = "playerList")
	@GetMapping
	public Page<PlayerDto> list(@RequestParam(required = false) String name,
			@PageableDefault(sort = "rating", direction = Direction.DESC, page = 0, size = 10) Pageable pageable) {

		if (name == null) {
			Page<Player> players = playerRepository.findAll(pageable);
			return PlayerDto.convert(players);

		} else {

			Page<Player> player = playerRepository.findByName(name, pageable);
			return PlayerDto.convert(player);

		}

	}

	@CacheEvict(value = "playerList", allEntries = true)
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

	@CacheEvict(value = "playerList", allEntries = true)
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

	@CacheEvict(value = "playerList", allEntries = true)
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {

		Optional<Player> optional = playerRepository.findById(id);
		if (optional.isPresent()) {
			playerRepository.deleteById(id);
			return ResponseEntity.ok().build();

		}

		return ResponseEntity.notFound().build();

	}

}
