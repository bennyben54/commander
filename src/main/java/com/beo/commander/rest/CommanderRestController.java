package com.beo.commander.rest;

import com.beo.commander.service.CommanderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/command")
public class CommanderRestController {

    private final CommanderService commanderService;

    @Autowired
    public CommanderRestController(CommanderService commanderService) {
        this.commanderService = commanderService;
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping(value = "/launch")
    public ResponseEntity<Integer> launch(Authentication authentication) {
        return ResponseEntity.ok(commanderService.launchChromium());
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping(value = "/stop")
    public ResponseEntity<Integer> stop(Authentication authentication) {
        return ResponseEntity.ok(commanderService.stopChromium());
    }

//    @Secured({"ROLE_ADMIN", "ROLE_USER"})
//    @GetMapping(value = "/titi")
//    public ResponseEntity<String> titi(Authentication authentication) {
//        return ResponseEntity.ok("titi " + authentication.getName());
//    }

}
