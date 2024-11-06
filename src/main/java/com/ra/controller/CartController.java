package com.ra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @GetMapping
    public ResponseEntity<?> cart(){
        return new ResponseEntity<>("Đây là trang gior hang", HttpStatus.OK);
    }
}
