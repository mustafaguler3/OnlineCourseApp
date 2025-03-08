package com.example.webapi.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actuator")
public class ActuatorController {

    private HealthEndpoint healthEndpoint;

    @GetMapping("/health")
    public Health health(){
        return (Health) healthEndpoint.health();
    }
}



















