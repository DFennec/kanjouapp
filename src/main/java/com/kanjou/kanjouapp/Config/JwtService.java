package com.kanjou.kanjouapp.Config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {

    private static final String KEY="kNVONduG7s5HVGdcF+1+aLMwXv0izawUYKQps98PUAkNvhXAlqqDrk0oEuTbgE6X";

    public String getEmail(String jwt) {
        return getClaim(jwt,Claims::getSubject);
    }
    public <T> T getClaim(String jwt, Function<Claims, T> claimsResolver) {
        Claims claims = getClaims(jwt);
        return claimsResolver.apply(claims);
    }

    private Claims getClaims(String jwt){
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(jwt).getBody();
    }
    
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }
    
    public String generateToken(Map<String, Object> extraClaims, UserDetails userdetails){                                                                                                                                                                                    
        return Jwts.builder().
        setClaims(extraClaims).setSubject(userdetails.getUsername()).                                                       /*aquí añado las horas que quiera que dure (una semana = 168 h)*/
        setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+ 1000 * 3600 * 168)).
        signWith(getSigningKey(),SignatureAlgorithm.HS256).compact();
    }

    public boolean isTokenValid(String jwt, UserDetails userDetails){
        final String email = getEmail(jwt);
        return (email.equals(userDetails.getUsername())&& !isTokenExpired(jwt));
    }

    public Date getExpiration(String jwt){
        return getClaim(jwt, Claims::getExpiration);
    }

    public boolean isTokenExpired(String jwt){
        return getExpiration(jwt).before(new Date(System.currentTimeMillis()));
    }

    public Key getSigningKey(){
        byte[] keyBytes=Decoders.BASE64.decode(KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
