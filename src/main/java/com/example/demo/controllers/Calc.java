package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;

@RestController
public class Calc {

    @PostMapping("/prod")
    public String createProduct(@RequestBody Product product) {
        System.out.println("Received product: " + product.getName());
        return "Ok";
    }

    @GetMapping("/calc/{oper}/{n1}/{n2}")
    @SuppressWarnings("ConvertToStringSwitch")
    public String calc(
            @PathVariable String oper, 
            @PathVariable float n1, 
            @PathVariable float n2) {
        
        float resultado = 0;
        if (oper.equals("suma")) {
            resultado = n1 + n2;
        }
        else if (oper.equals("resta")) {
            resultado = n1 - n2;
        }
        else if (oper.equals("mult")) {
            resultado = n1 * n2;
        }
        else if (oper.equals("div")) {
            resultado = n1 / n2;
        }
        
        return "Resultado de la " + oper + " es: " + resultado;
    }

    @GetMapping("/users/{userId}")
    public String getUserDetails(@PathVariable Long userId, 
            @RequestParam(value = "name", defaultValue = "World") String name) {
        return "User ID: " + userId + ", " + name;
    }
}