package br.com.chessapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chessapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);	
	
}
