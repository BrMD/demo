package com.example.demo.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.User;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    public static String generateToken(User user){
        return Jwts.builder().subject(user.getUsername())
                .expiration(new Date(System.currentTimeMillis()+300000)).signWith(getSigningKey()).compact();
    }

    private static SecretKey getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode("YourSecretKeyAndItMustBeLongEnoughForSecurity");
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public static Claims getClaims(String token){
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
    }

    public static boolean isTokenValid(String token){
        return !isExpired(token);
    }

    private static boolean isExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
}
