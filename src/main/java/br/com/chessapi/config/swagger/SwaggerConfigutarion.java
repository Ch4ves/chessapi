package br.com.chessapi.config.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.chessapi.model.User;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigutarion {
	@Bean
	public Docket chessApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.chessapi")).paths(PathSelectors.ant("/**")).build()
				.ignoredParameterTypes(User.class).globalOperationParameters(
						Arrays.asList(new ParameterBuilder().name("Authorization").description("JWT Token Header")
								.modelRef(new ModelRef("string")).parameterType("header").required(false).build()));
	}

}
