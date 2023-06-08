package com.mdbytes.security.demo.resources;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityResource {

    @GetMapping("/csrf-token")
    public CsrfToken retrieveToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
