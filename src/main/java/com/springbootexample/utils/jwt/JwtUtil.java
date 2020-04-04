package com.springbootexample.utils.jwt;

import com.springbootexample.entities.User;
import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Log4j2
public class JwtUtil {

    private static final Logger logger = LogManager.getLogger(JwtUtil.class);

    @Value("${jwt.secret.key}")
    private String jwtSecretKey;

    @Value("${jwt.time.to.live}")
    private Long jwtTimeToLive;

    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtTimeToLive);
        return Jwts.builder()
                .setSubject(user.getIdentifier())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                .compact();
    }

    public String getUserIdFromJWT(String authToken) {
        return Jwts.parser()
                .setSigningKey(jwtSecretKey)
                .parseClaimsJws(authToken)
                .getBody().getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

    public String getTokenFromHeaders(Map<String, String> headers) {
        return headers.entrySet()
                .stream()
                .filter(data -> data.getKey().equals("authorization"))
                .map(Map.Entry::getValue).collect(Collectors.joining()).split("Bearer")[1].trim();
    }

}
