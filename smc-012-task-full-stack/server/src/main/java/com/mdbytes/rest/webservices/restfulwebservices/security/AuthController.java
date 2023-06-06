package com.mdbytes.rest.webservices.restfulwebservices.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping(path = "/auth")
    public String basicAuthCheck() {
        return "Success";
    }
}
