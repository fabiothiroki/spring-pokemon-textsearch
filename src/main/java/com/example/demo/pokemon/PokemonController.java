package com.example.demo.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController()
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonRepository repository;

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping(value = "/{id}")
    public Pokemon findById(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping()
    public List<Pokemon> findByDescription(@RequestParam String search) {
        return repository.search(search);
    }


    @RequestMapping("/migrate")
    String migrate() {
        if (repository.count() > 0) {
            return "already migrated";
        }

        try {
            InputStream inputStream = new ClassPathResource("pokemon.csv").getInputStream();

            List<Pokemon> pokemons = PokemonReader.readFile(inputStream);
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
