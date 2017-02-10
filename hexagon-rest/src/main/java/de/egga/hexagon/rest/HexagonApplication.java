package de.egga.hexagon.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.egga.hexagon.persistence.SimplePostRepository;
import de.egga.hexagon.posts.PostService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class HexagonApplication {

	public static void main(String[] args) {
		run(HexagonApplication.class, args);
	}

	@Bean
	public ObjectMapper jacksonObjectMapper() {
		return new ObjectMapper().setPropertyNamingStrategy(SNAKE_CASE);
	}

	@Bean
	public PostService postService() {
		return new PostService(new SimplePostRepository());
	}
}

