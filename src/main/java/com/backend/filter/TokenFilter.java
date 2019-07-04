package com.backend.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

/**
 * Classe responsavel por gerar o token de autenticacao.
 * 
 * @author jd-davi
 *
 */
public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String header = req.getHeader("Authorization");

		if (header == null || !header.startsWith("Bearer ")) {
			throw new ServletException("Token inexistente ou mal formatado!");
		}

		// Extraindo apenas o token do cabecalho.
		String token = header.substring(7);

		try {
			Jwts.parser().setSigningKey("banana").parseClaimsJws(token).getBody();
		} catch (SignatureException e) {
			throw new ServletException("Token invalido ou expirado!");
		}

		chain.doFilter(request, response);
	}

}
