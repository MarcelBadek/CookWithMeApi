package org.example.cookwithmeapi.service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import io.jsonwebtoken.Claims;
import org.example.cookwithmeapi.model.account.Account;


public interface JwtService {
    String extractUserName(String token);
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);
    boolean isTokenExpired(String token);
    Date extractExpiration(String token);
    Claims extractAllClaims(String token);
    Key getSigningKey();
}
