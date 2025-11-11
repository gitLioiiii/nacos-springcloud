package com.example.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/")
    public String index() {
        if ((int) Math.floor(Math.random() * 10) == 5) {
            throw new RuntimeException("runtime exception");
        }

        return this.port;
    }

    @GetMapping("/{id}")
    public Integer fetch(
        @PathVariable("id") Integer id
    ) {
        if ((int) Math.floor(Math.random() * 10) == 5) {
            throw new RuntimeException("runtime exception");
        }

        return id;
    }

}
