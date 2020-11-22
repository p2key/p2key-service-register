package com.p2key.service.security.services;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.p2key.service.security.dto.AuthDTO;
import com.p2key.service.security.dto.TokenDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthManager {
	private static String SECRET_KEY = "oeRaYY7Wo24sDqKSX3IM9ASGmdGPmkTd9jo1QTy4b7P9Ze5_9hKolVX8xNrQDcNRfVEdTZNOuOyqEGhXEbdJI-ZQ19k_o9MI0y3eZN2lp9jow55FfXMiINEdt1XR85VipRLSOkT6kSpzs2x-jbLDiz9iFVzkd81YKxMgPA7VfZeQUm4n-mOmnWMaVX30zGFU4L3oPBctYKkl4dYfqYWqRNfrgPJVi5DGFjywgxx0ASEiJHtV72paI3fDR2XwlSkyhhmY-ICjCRmsJN4fX1pdoL8a18-aQrvyu4j0Os6dVPYIoPvvY0SAZtWYKHfM15g7A3HD4cVREf9cUsprCRK93w";

	public static TokenDTO authenticate(AuthDTO auth) {
		TokenDTO token = null;
		if ("admin".equals(auth.getUserName()) && "pass".equals(auth.getPassword())) {
			token = new TokenDTO(createJWT(60000));
		}
		return token;
	}

	public static void validate(TokenDTO token) {
		decodeJWT(token.getToken());
	}

	private static String createJWT(long expireTimeMs) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMs = System.currentTimeMillis();
		Date now = new Date(nowMs);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		JwtBuilder builder = Jwts.builder().setId("P2KEY_AUTH").setIssuedAt(now).setSubject("service_register")
				.setIssuer("p2Key").signWith(signatureAlgorithm, signingKey);

		if (expireTimeMs >= 0) {
			long expMs = nowMs + expireTimeMs;
			Date exp = new Date(expMs);
			builder.setExpiration(exp);
		}

		return builder.compact();
	}

	private static Claims decodeJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.parseClaimsJws(token).getBody();
		return claims;
	}

}
