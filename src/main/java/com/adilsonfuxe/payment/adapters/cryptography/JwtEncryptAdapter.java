package com.adilsonfuxe.payment.adapters.cryptography;

import com.adilsonfuxe.payment.core.data.porters.out.cryptography.Encrypt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtEncryptAdapter implements Encrypt {
  private static final String SECRET_KEY = "VVd2Y2cjSSFreyY/YkBATDNfeWtJQU9xQyssMUQsYUc=";

  @Override
  public String encrypt(String userId) {
    return generateToken(new HashMap<>(), userId);
  }

  private String generateToken(Map<String, Object> extractClaims, String userId) {
    return Jwts
        .builder()
        .setClaims(extractClaims)
        .setSubject(userId)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
        .signWith(getSigninKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  public String extractUserId(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public boolean isTokenValid(String token, String userId) {
    final String username = extractUserId(token);
    return (username.equals(userId)) && !isTokenExpired(token);
  }

  private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  private Claims extractAllClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(getSigninKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  private Key getSigninKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }

}
