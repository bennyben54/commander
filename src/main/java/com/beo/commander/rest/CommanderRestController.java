package com.beo.commander.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/command")
public class CommanderRestController {

    @Autowired
    public CommanderRestController() {
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping(value = "/toto")
    public ResponseEntity<String> toto(Authentication authentication) {
        return ResponseEntity.ok("toto " + authentication.getName());
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping(value = "/titi")
    public ResponseEntity<String> titi(Authentication authentication) {
        return ResponseEntity.ok("titi " + authentication.getName());
    }

}
