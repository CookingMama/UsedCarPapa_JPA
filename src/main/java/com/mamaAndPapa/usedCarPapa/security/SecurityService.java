package com.mamaAndPapa.usedCarPapa.security;

import com.mamaAndPapa.usedCarPapa.domain.entity.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityService {
    @Value("${jwt.SECRET_KEY}")
    private String SECRET_KEY;

    @Value("${jwt.EXP_TIME}")
    private String EXP_TIME;

    public String createToken(Users users) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        byte[] secretKeyByte = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key key = new SecretKeySpec(secretKeyByte, signatureAlgorithm.getJcaName());
        Map<String, Object> map = new HashMap<>();
        map.put("id", users.getId());
        map.put("name", users.getName());
        map.put("phoneNumber", users.getPhoneNumber());
        map.put("local", users.getLocale());
        map.put("nickName", users.getNickName());
        map.put("email", users.getEmail());
        return Jwts.builder().setClaims(map)
                .signWith(key)
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(EXP_TIME) * 24))
                .compact();

    }
    public TokenInfo parseToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(DatatypeConverter
                        .parseBase64Binary(SECRET_KEY))
                .build()
                .parseClaimsJws(token)
                .getBody();
        TokenInfo info = new TokenInfo().parseToken(claims);

        return info;

    }
    public String getToken() {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request.getHeader("authorization");
    }
}
