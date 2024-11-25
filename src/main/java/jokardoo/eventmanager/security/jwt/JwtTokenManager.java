package jokardoo.eventmanager.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenManager {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public Claims getClaims(String jwt) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseClaimsJws(jwt)
                .getBody();

        return claims;
    }

    public String getLoginFromClaims(Claims claims) {
        return claims.getSubject();
    }

    public String getRoleFromClaims(Claims claims) {
        return claims
                .get("role", String.class);
    }

    public Long getUserIdFromClaims(Claims claims) {
        return claims.get("userId", Long.class);

    }

}