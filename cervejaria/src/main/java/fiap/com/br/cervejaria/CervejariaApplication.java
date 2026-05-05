package fiap.com.br.cervejaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CervejariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CervejariaApplication.class, args);
	}

}
