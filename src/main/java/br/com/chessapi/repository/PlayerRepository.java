package br.com.chessapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chessapi.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	List<Player> findByName(String name);

}
