package fiap.com.br.brewery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BreweryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreweryApplication.class, args);
	}

}