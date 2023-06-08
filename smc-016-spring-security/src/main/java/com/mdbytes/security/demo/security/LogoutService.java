package com.mdbytes.security.demo.security;

import com.mdbytes.security.demo.dao.TokenRepository;
import com.mdbytes.security.demo.entity.Token;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
public class LogoutService implements LogoutHandler {

    private final TokenRepository tokenRepository;

    @Autowired
    public LogoutService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        jwt = authHeader.substring(7);
        var result = tokenRepository.findByToken(jwt);
        if (result != null) {
            Token storedToken = result.get();
            storedToken.setRevoked(true);
            storedToken.setExpired(true);
            tokenRepository.save(storedToken);
        }
    }
}
