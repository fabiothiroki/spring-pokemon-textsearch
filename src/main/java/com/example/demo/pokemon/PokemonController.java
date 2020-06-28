package com.example.demo.pokemon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @RequestMapping("/migrate")
    String migrate() {
        return "Hello World!";
    }
}
