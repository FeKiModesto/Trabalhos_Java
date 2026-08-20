package br.com.fiap.carsaleapi.auth;

import br.com.fiap.carsaleapi.domain.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    private final JwtEncoder encoder;

    public TokenService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public Token generateToken(Authentication authentication) {
        Instant now = Instant.now();

        var role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_USER");

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(2, ChronoUnit.MINUTES))
                .subject(authentication.getName())
                .claim("role", role)
                .build();

        User principal = (User) authentication.getPrincipal();
        var token = new Token(
                this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue(),
                authentication.getName(),
                principal.getId().toString(),
                role
        );

        return token;
    }

}
