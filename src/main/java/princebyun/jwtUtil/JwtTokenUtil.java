package princebyun.jwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenUtil {

    // JWT Token 발급

    /**
     * JWT Token 발급
     * @param loginId
     * @param key
     * @param expireTimesMs
     * @return
     */
    public static String createToken(String loginId,String key,long expireTimesMs){
        // Claim = Jwt Token에 들어갈 정보
        // Claim에 loginId를 넣어 줌으로써 나중에 loginId를 꺼낼 수 있음


        Claims claims = Jwts.claims();
        claims.put("loginId",loginId);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireTimesMs))
                .signWith(SignatureAlgorithm.HS256,key)
                .compact();
    }














}








