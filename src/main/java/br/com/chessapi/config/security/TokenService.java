package br.com.chessapi.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.chessapi.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${chessapi.jwt.expiration}")
	private String expiration;

	@Value("${chessapi.jwt.secret}")
	private String secret;

	
	public String generateToken(Authentication authentication) {

		User signedIn = (User) authentication.getPrincipal();
		Date today = new Date();
		Date expirationDate = new Date(today.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("Chess API")
				.setSubject(signedIn.getId().toString())
				.setIssuedAt(today)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	
	
	
}
