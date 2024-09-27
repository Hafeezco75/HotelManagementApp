package com.hotel.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtil {

    private String secretKey = "your_secret_key"; // Use a secure key in production
    private long validityInMilliseconds = 3600000; // 1 hour

    // Generate JWT token
    public String generateToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Validate JWT token
    public boolean validateToken(String token, String username) {
        Claims claims = getAllClaimsFromToken(token);
        return (claims.getSubject().equals(username) && !claims.getExpiration().before(new Date()));
    }

    // Extract username from token
    public String getUsername(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    // Get all claims from token
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token) // This should work if the dependency is correct
                .getBody();
    }
}
