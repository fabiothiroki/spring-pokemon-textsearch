package com.example.demo.pokemon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    private PokemonRepository repository;

    @RequestMapping("/migrate")
    String migrate() {
        if (repository.count() > 0) {
            return "already migrated";
        }

        try {
            File file = new ClassPathResource("/pokemon.csv").getFile();

            List<Pokemon> pokemons = PokemonReader.readFile(file);
            for (Pokemon pokemon : pokemons) {
                repository.save(pokemon);
            }
            return "success";
        } catch (Exception e){
            System.out.println("Unable to save pokemon: " + e.getMessage());
            return "error";
        }
    }
}
