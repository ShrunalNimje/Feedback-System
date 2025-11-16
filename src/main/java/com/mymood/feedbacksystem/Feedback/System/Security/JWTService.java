package com.mymood.feedbacksystem.Feedback.System.Security;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mymood.feedbacksystem.Feedback.System.Enum.Role;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JWTService {

private String secret_key;
	
	public JWTService() {
		
		this.secret_key = Base64.getEncoder()
				.encodeToString("MyVerySecretKey1234567890dfhbnbkidfneirg25r34hr65jn!".getBytes());
	}
	
	public String generateToken(String username) {
		
		System.out.println("Current time: " + System.currentTimeMillis());
		System.out.println("JWT expiration: " + (System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7));

		Map<String, Object> claims = new HashMap<>();
		
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 7)))
				.and()
				.signWith(getKey())
				.compact();
		
	}

	public String generateTokenWithRole(String username, Role role) {
		
		System.out.println("Current time: " + System.currentTimeMillis());
		System.out.println("JWT expiration: " + (System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7));

		Map<String, Object> claims = new HashMap<>();
		claims.put("role", role.name());
		
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 7)))
				.and()
				.signWith(getKey())
				.compact();
		
	}

	private SecretKey getKey() {
		byte [] keyBytes = Decoders.BASE64.decode(secret_key);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	 public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

	public String extractRole(String token) {
		return extractAllClaims(token).get("role", String.class);
	}
	
    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
