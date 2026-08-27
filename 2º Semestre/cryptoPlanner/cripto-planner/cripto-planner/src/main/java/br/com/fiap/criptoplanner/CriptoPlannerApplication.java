package br.com.fiap.criptoplanner;

import br.com.fiap.criptoplanner.crypto.CryptoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.service.registry.ImportHttpServices;

@SpringBootApplication
@ImportHttpServices(CryptoService.class)
public class CriptoPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CriptoPlannerApplication.class, args);
    }

}
