package com.platzi.market.web.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
public class JWTUtil {
  private static final String KEY = "pl4tz1";

  public String generateToken(UserDetails userDeails){
    return Jwts.builder().setSubject(userDeails.getUsername()).setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
        .signWith(SignatureAlgorithm.HS256, KEY ).compact();
  }

}
