package br.com.chessapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableCaching
@SpringBootApplication
@EnableSpringDataWebSupport
public class ChessapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessapiApplication.class, args);
	}

}
