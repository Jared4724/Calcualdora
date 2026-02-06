package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/") 
    public String saludar() {
        return "Hola Mundo";
    }

    @GetMapping("/hello")
    public String hello(
            @RequestParam(value = "name", defaultValue = "World") String name, 
            @RequestParam(value = "carrera", defaultValue = "World") String carrera) { 
        return String.format("Hello %s, Carrera: %s", name, carrera);
    }
}