package br.com.chessapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chessapi.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	Page<Player> findByName(String name, Pageable pageable);

}
