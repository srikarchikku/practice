package com.project.springboot.Tokens;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {


    public String key = "secret";

    public String createToken(String id, String subject)
    {
        return Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuer("Freshworks")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(1)))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public Claims getTokendata(String token)
    {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isValid(String token)
    {
        return getTokendata(token).getExpiration().after(new Date(System.currentTimeMillis()));
    }
}
