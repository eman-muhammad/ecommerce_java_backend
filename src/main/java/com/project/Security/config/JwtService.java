package com.project.Security.config;

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

    private static final String SECRET_KEY = "39792F423F4528482B4D6251655468576D5A7134743777217A25432646294A40";

    public String extractUserName(String token) {

        // subject is here email
        return extractClaim(token, Claims::getSubject);
    }

    // first getting claims in token (payload)
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // get sign in key
    // sign in key + alg in header used to create Signature
    private Key getSignInKey() {

        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

        // hmacShaKeyFor take bytes and retun Key
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // extract single claim (email)
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    

    // generate token with extraClaims as setExpiration,setIssuedAt
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // generate token with out extraClaims using user details only
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);

        // return Jwts
        // .builder()
        // .setSubject(userDetails.getUsername())
        // .setIssuedAt(new Date(System.currentTimeMillis()))
        // .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
        // .signWith(getSignInKey(), SignatureAlgorithm.HS256)
        // .compact();
    }


    //path the user details  to validate if token belongs to this user 
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
     
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


    // return claim Expiration  date and get date
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

}
