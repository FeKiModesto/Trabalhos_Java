package br.com.fiap.commandservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommandController {

    private final RestTemplate restTemplate;

    public record CommandRequest(String command) {}
    public record ValidatorResponse(String status) {}

    @Retryable(
            includes = RestClientException.class,
            maxRetries = 5,
            delay = 500,
            jitter = 20,
            multiplier = 2,
            maxDelay = 10_000
    )
    @PostMapping("/command")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ValidatorResponse sendCommand(@RequestBody CommandRequest request) {
        log.info("Enviando comando para validação: {}", request.command());

        ValidatorResponse response = restTemplate.postForObject(
                "http://VALIDATOR-SERVICE/validate",
                request,
                ValidatorResponse.class
        );

        log.info("🟢 Resposta do validator: {}", response.status());
        return response;
    }

}
