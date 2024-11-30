package jokardoo.eventmanager.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jokardoo.eventmanager.domain.user.Role;
import jokardoo.eventmanager.domain.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.util.List;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenManager jwtTokenManager;
    @Value("${jwt.secret}")
    private String secret;

    private final Logger logger = LoggerFactory.getLogger(JwtTokenManager.class);


    public JwtTokenFilter(JwtTokenManager jwtTokenManager) {
        this.jwtTokenManager = jwtTokenManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwtToken = authHeader.substring(7);

        String loginFromToken;
        Claims claims;

        try {
            SignatureAlgorithm sa = SignatureAlgorithm.HS256;
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), sa.getJcaName());

            Jwts.parser().setSigningKey(secretKeySpec).parse(jwtToken);
        }
        catch (Exception e) {
            logger.error("Invalid token", e);
            filterChain.doFilter(request, response);
            return;
        }

        try {
            claims = jwtTokenManager.getClaims(jwtToken);
            loginFromToken = jwtTokenManager.getLoginFromClaims(claims);


        } catch (Exception e) {
            logger.error("Error while reading jwt", e);
            filterChain.doFilter(request, response);
            return;
        }

        User user = new User(loginFromToken, Role.valueOf(jwtTokenManager.getRoleFromClaims(claims)));
        user.setId(jwtTokenManager.getUserIdFromClaims(claims));

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user,
                null,
                List.of(new SimpleGrantedAuthority(jwtTokenManager.getRoleFromClaims(claims)))
        );

        SecurityContextHolder.getContext().setAuthentication(token);
        filterChain.doFilter(request, response);
    }
}
